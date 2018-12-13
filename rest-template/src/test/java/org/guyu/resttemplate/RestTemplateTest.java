package org.guyu.resttemplate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * @author guyu
 * created at 2018/11/6 2:06 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RestTemplateTest {

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private RestTemplate restTemplateWithoutPool;

    @Test
    public void testSpeedUsingPool() {
        String url = "http://10.1.3.13:8080/actuator/health";
        int loop = 10;
//        System.err.println("start use restTemplate");
//        task(url, loop, restTemplate);
        System.err.println("start use restTemplateWithoutPool");
        task(url, loop, restTemplateWithoutPool);
    }

    private void task(String url, int loop, RestTemplate restTemplate) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            restTemplate.getForObject(url, String.class);
        }
        long end = System.currentTimeMillis();
        System.err.format("cost %d ms\n", (end-start));
    }

}
