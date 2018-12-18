package org.guyu.serviceb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/service_b")
@Slf4j
@SpringBootApplication
public class ServiceBApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceBApplication.class, args);
    }

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping
    public String list(@RequestBody RequestParam requestParam) {
        String result = restTemplate.getForObject("http://www.example.com", String.class);
        if (!requestParam.isIncludeErr()) {
            throw new IllegalStateException("unkown exception???");
        }
        return result;
    }

    @GetMapping("/constant")
    public String constant() {
        restTemplate.getForObject("http://localhost:10010/service_c1/constant", String.class);
        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "ok";
    }

}

