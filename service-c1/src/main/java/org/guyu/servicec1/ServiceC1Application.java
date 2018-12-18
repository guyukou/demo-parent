package org.guyu.servicec1;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/service_c1")
@Slf4j
@SpringBootApplication
public class ServiceC1Application {

    @Autowired
    private RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(ServiceC1Application.class, args);
    }

    @PostMapping
    public String dosth(@RequestBody RequestParam requestParam) {
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        String requestJson = JSON.toJSONString(requestParam);
        HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);
        return restTemplate.exchange("http://localhost:10022/service_c2",
                HttpMethod.POST,
                entity,String.class
        ).getBody();
    }

    @GetMapping("/constant")
    public String constant() {
        restTemplate.getForObject("http://localhost:10022/service_c2/constant", String.class);
        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "ok";
    }

}

