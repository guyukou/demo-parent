package org.guyu.servicea;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author guyu
 * created at 2018/12/28 12:12 PM
 */
@Component
public class MySchedule {
    @Autowired
    private RestTemplate restTemplate;
    @Scheduled(fixedRate = 1000*30)
    public void dosth() {
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        RequestParam requestParam = new RequestParam();
        requestParam.setIncludeAll(true);
        requestParam.setIncludeErr(true);
        String requestJson = JSON.toJSONString(requestParam);
        HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);
        String bResult = restTemplate.exchange("http://localhost:10010/service_b",
                HttpMethod.POST,
                entity, String.class
        ).getBody();
    }
}
