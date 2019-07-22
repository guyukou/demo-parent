package org.guyu.resttemplate.config;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author guyu
 * created at 2019/7/9 10:19 AM
 */
//@Component
public class PoolCustomizer implements RestTemplateCustomizer {
    @Override
    public void customize(RestTemplate restTemplate) {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setDefaultMaxPerRoute(1);
        CloseableHttpClient httpClient = HttpClientBuilder.create()
//                .setMaxConnPerRoute(2)
//                .setMaxConnTotal(1)
                .setConnectionManager(connectionManager)
                .build();
        restTemplate.setRequestFactory(
                new HttpComponentsClientHttpRequestFactory(httpClient));
    }
}
