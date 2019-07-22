package org.guyu.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author guyu
 * created at 2019/1/29 5:56 PM
 */
public class Main {
    public static void main(String[] args) {
        ServiceLoader<DemoInterface> serviceLoader = ServiceLoader.load(DemoInterface.class);
        Iterator<DemoInterface> it = serviceLoader.iterator();
        while (it!=null && it.hasNext()) {
            DemoInterface demoService = it.next();
            System.out.println("class:"+demoService.getClass().getName());
            demoService.dosth();
        }
    }
}
