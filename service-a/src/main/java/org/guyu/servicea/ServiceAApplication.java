package org.guyu.servicea;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.*;

@RestController
@RequestMapping("/service_a")
@Slf4j
@SpringBootApplication
public class ServiceAApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceAApplication.class, args);
    }

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/list")
    public String list(@RequestBody RequestParam requestParam) {
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        String requestJson = JSON.toJSONString(requestParam);
        HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);
        String bResult = restTemplate.exchange("http://localhost:10010/service_b",
                HttpMethod.POST,
                entity, String.class
        ).getBody();
        String cResult = restTemplate.exchange("http://localhost:10021/service_c1",
                HttpMethod.POST,
                entity, String.class
        ).getBody();
        return cResult;
    }

    @GetMapping("/get")
    public String get() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> submit = executorService.submit(() -> restTemplate.getForObject("http://www.example.com", String.class));
        return submit.get();
    }

}

