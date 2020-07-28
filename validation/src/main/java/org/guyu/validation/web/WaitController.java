package org.guyu.validation.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author guyu
 * @date 2019-12-16
 */
@RestController
@RequestMapping("/w")
public class WaitController {

    @GetMapping("/wait")
    public String waittt() {
        synchronized (this) {
            try {
                this.wait();
            try { TimeUnit.SECONDS.sleep(5L); } catch (InterruptedException e) { e.printStackTrace(); }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "waiting";
    }

    @GetMapping("/wait2")
    public String waittt2() {
        synchronized (this) {
//            try { TimeUnit.SECONDS.sleep(5L); } catch (InterruptedException e) { e.printStackTrace(); }
            try {
                this.wait(2000);
//                try { TimeUnit.SECONDS.sleep(5L); } catch (InterruptedException e) { e.printStackTrace(); }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "waiting";
    }

    @GetMapping("/notify")
    public String notifyyy() {
        synchronized (this) {
            this.notify();
//            try { TimeUnit.SECONDS.sleep(5L); } catch (InterruptedException e) { e.printStackTrace(); }
        }

        return "notified";
    }

    @GetMapping("/getLock")
    public String getLock() {
        synchronized (this) {
            try { TimeUnit.SECONDS.sleep(10L); } catch (InterruptedException e) { e.printStackTrace(); }

            System.out.println("got lock");
        }
        return "got lock";
    }

    @GetMapping("/notifyAll")
    public String notifyyyAll() {
        synchronized (this) {
            this.notifyAll();
//            try { TimeUnit.SECONDS.sleep(5L); } catch (InterruptedException e) { e.printStackTrace(); }
        }

        return "notified";
    }
}
