package org.guyu.resttemplate.config;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * RestTemplate configured with connection pool and different sorts of timeout
 *
 * @author guyu
 * @date 2019-11-12
 */
@Configuration
public class RestConfig {
    private static final int TIME_OUT = 1000;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public RestTemplateCustomizer meteorRestTemplateCustomizer() {
        return restTemplate ->
                restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory(buildClient()));
    }

    private static HttpClient buildClient() {
        HttpClientBuilder builder = HttpClientBuilder.create().disableCookieManagement();

        DefaultHttpRequestRetryHandler retryHandler = new DefaultHttpRequestRetryHandler();
        builder.setRetryHandler(retryHandler);
        builder.setConnectionTimeToLive(TIME_OUT, TimeUnit.MILLISECONDS);
        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setConnectTimeout(TIME_OUT)
                .setSocketTimeout(TIME_OUT)
                .setRedirectsEnabled(true)
                .setConnectionRequestTimeout(TIME_OUT)
                .build();
        builder.setDefaultRequestConfig(defaultRequestConfig);
        builder.setMaxConnTotal(200);
        builder.setMaxConnPerRoute(200);
        builder.evictExpiredConnections();
        builder.evictIdleConnections(6, TimeUnit.SECONDS);
        return builder.build();
    }
}
