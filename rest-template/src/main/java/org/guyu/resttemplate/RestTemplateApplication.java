package org.guyu.resttemplate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author guyu
 * created at 2018/11/6 11:38 AM
 */
@SpringBootApplication
@Slf4j
public class RestTemplateApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(RestTemplateApplication.class, args);
    }

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public void run(String... args) throws Exception {
       /* ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.execute(()->{
                String responseStr = restTemplate.getForObject("http://localhost:20000/rest", String.class);
                System.out.println(responseStr);
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        System.exit(1);*/
    }
}