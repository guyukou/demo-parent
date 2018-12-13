package org.guyu.resttemplate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author guyu
 * created at 2018/11/6 2:06 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RestTemplateDefaultConfigTest {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RestTemplate restTemplateWithoutPool;
    private ExecutorService executorService = Executors.newFixedThreadPool(20);

    @Test
    public void testSpeedUsingPool() {
        task(restTemplate);
        task(restTemplateWithoutPool);
    }

    private void task(RestTemplate restTemplate) {
        CountDownLatch countDownLatch = new CountDownLatch(200);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 200; i++) {
            executorService.execute(()->{
                restTemplate.getForObject("http://10.1.3.13:8080/actuator/health", String.class);
                countDownLatch.countDown();
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.err.format("cost %d ms\n", (end - start));

    }


}
