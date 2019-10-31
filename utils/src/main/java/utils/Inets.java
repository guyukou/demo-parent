package utils;


import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * copy from com.dianping.cat:vkcat-client:2.1.4
 * @author guyu
 * @date 2019-10-31
 */
public enum Inets {
    /**
     * IP4
     */
    IP4 {
        @Override
        protected List<Address> getAllInetAddresses() {
            List<Address> all = new ArrayList<>();

            try {
                List<NetworkInterface> nis = Collections.list(NetworkInterface.getNetworkInterfaces());

                for (NetworkInterface ni : nis) {
                    print(ni);

                    if (ni.isUp()) {
                        List<InetAddress> addresses = Collections.list(ni.getInetAddresses());

                        for (InetAddress address : addresses) {
                            if (address instanceof Inet4Address) {
                                all.add(new Address(address, ni));
                            }
                        }
                    }
                }
            } catch (SocketException e) {
                if (isVerbose()) {
                    e.printStackTrace();
                }
            }

            return all;
        }
    };

    private InetAddress m_localHost;

    private String m_localHostAddress;

    private String m_localHostName;

    private AtomicBoolean m_initialized = new AtomicBoolean();

    public static void main(String[] args) {
        System.out.println(IP4.getLocalHostAddress());
        System.out.println(IP4.getLocalHostName());

    }

    public InetAddress getLocalHost() {
        initialize();

        return m_localHost;
    }

    public String getLocalHostAddress() {
        initialize();

        return m_localHostAddress;
    }

    public String getLocalHostName() {
        initialize();

        return m_localHostName;
    }

    protected abstract List<Address> getAllInetAddresses();

    protected boolean isVerbose() {
        String verbose = System.getProperty("verbose");

        return "true".equals(verbose);
    }

    protected void print(NetworkInterface ni) throws SocketException {
        if (isVerbose()) {
            StringBuilder sb = new StringBuilder();

            sb.append(ni.getName()).append(": ");
            sb.append("flags=<");

            if (ni.isUp()) {
                sb.append("UP,");
            }

            if (ni.isLoopback()) {
                sb.append("LOOPBACK,");
            }

            if (ni.isPointToPoint()) {
                sb.append("POINTOPOINT,");
            }

            if (ni.isVirtual()) {
                sb.append("VIRTUAL,");
            }

            if (ni.supportsMulticast()) {
                sb.append("MULTICAST,");
            }

            if (sb.charAt(sb.length() - 1) == '<') {
                sb.append('>');
            } else {
                sb.setCharAt(sb.length() - 1, '>');
            }

            sb.append(" mtu ").append(ni.getMTU());
            sb.append("\r\n");

            for (InetAddress address : Collections.list(ni.getInetAddresses())) {
                if (address instanceof Inet4Address) {
                    sb.append("    ").append(address.getHostAddress());
                    sb.append(" flags=<");

                    if (address.isSiteLocalAddress()) {
                        sb.append("sitelocal,");
                    }

                    if (address.isLinkLocalAddress()) {
                        sb.append("linklocal,");
                    }

                    if (address.isLoopbackAddress()) {
                        sb.append("loopback,");
                    }

                    if (sb.charAt(sb.length() - 1) == '<') {
                        sb.append('>');
                    } else {
                        sb.setCharAt(sb.length() - 1, '>');
                    }

                    sb.append("\r\n");
                }
            }

            System.out.println(sb.toString());
        }
    }

    protected void print(String message) {
        if (isVerbose()) {
        }
    }

    private InetAddress getLocalInetAddress() {
        String ip = System.getProperty("host.ip");

        if (ip == null) {
            ip = System.getenv("HOST_IP");
        }

        if (ip != null) {
            try {
                return InetAddress.getByName(ip);
            } catch (Exception e) {
                print("Unable to resolve ip: " + ip + "! " + e);
            }
        }

        List<Address> addresses = getAllInetAddresses();
        InetAddress address = filterAddresses(addresses);

        return address;
    }

    private synchronized void initialize() {
        if (!m_initialized.get()) {
            m_localHost = getLocalInetAddress();

            if (m_localHost == null) {
                try {
                    m_localHost = Inet4Address.getLocalHost();
                } catch (UnknownHostException e) {
                    String message = "No network configured!";

                    print(message);
                    throw new IllegalStateException(message);
                }
            }

            m_localHostAddress = m_localHost.getHostAddress();
            m_localHostName = m_localHost.getHostName();
            m_initialized.set(true);

        }
    }

    static class Address {
        private InetAddress m_address;

        private boolean m_loopback;

        public Address(InetAddress address, NetworkInterface ni) {
            m_address = address;

            try {
                if (ni != null && ni.isLoopback()) {
                    m_loopback = true;
                }
            } catch (SocketException e) {
            }
        }

        public InetAddress getAddress() {
            return m_address;
        }

        public boolean hasHostName() {
            return !m_address.getHostName().equals(m_address.getHostAddress());
        }

        public boolean isLinkLocalAddress() {
            return !m_loopback && m_address.isLinkLocalAddress();
        }

        public boolean isLoopbackAddress() {
            return m_loopback || m_address.isLoopbackAddress();
        }

        public boolean isSiteLocalAddress() {
            return !m_loopback && m_address.isSiteLocalAddress();
        }
    }

    InetAddress filterAddresses(List<Address> addresses) {
        InetAddress local = null;
        int size = addresses.size();
        int maxWeight = -1;

        for (int i = 0; i < size; i++) {
            Address address = addresses.get(i);
            int weight = 0;

            if (address.isSiteLocalAddress()) {
                weight += 8;
            }

            if (address.isLinkLocalAddress()) {
                weight += 4;
            }

            if (address.isLoopbackAddress()) {
                weight += 2;
            }

            if (address.hasHostName()) {
                weight += 1;
            }

            if (weight > maxWeight) {
                maxWeight = weight;
                local = address.getAddress();
            }
        }

        return local;
    }
}

