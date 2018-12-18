package org.guyu.servicec2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/service_c2")
@Slf4j
@SpringBootApplication
public class ServiceC2Application {
    @Autowired
    private ServiceM serviceM;

    public static void main(String[] args) {
        SpringApplication.run(ServiceC2Application.class, args);
    }

    @PostMapping
    public Object dosth(@RequestBody RequestParam requestParam) {
        return serviceM.m1(requestParam);
    }

    @GetMapping("/constant")
    public String constant() {
        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "ok";
    }

}

