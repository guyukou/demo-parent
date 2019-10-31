package org.guyu.resttemplate.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author guyu
 * created at 2018/11/6 11:44 AM
 */
@Slf4j
@Configuration
public class RestTemplateConfig2 {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        
        RestTemplate build = restTemplateBuilder.build();
        ClientHttpRequestFactory requestFactory = build.getRequestFactory();
        HttpComponentsClientHttpRequestFactory fac = (HttpComponentsClientHttpRequestFactory) requestFactory;
        fac.getHttpClient().getConnectionManager();
        return build;
    }

    @Bean
    public RestTemplateCustomizer customizer() {
        return restTemplate -> {
            HttpClientBuilder builder = HttpClientBuilder.create().disableCookieManagement();


            //connectionRequestTimeout:
            //连接池模式时，从pool中获取连接的阻塞最大时长。默认是连接池，默认永久阻塞。
            //RT最大为1.5S
            //连接数最大为1024
            //每个域名最多连接数64
            //如果上述值，需要修改，请用户自己手动创建客户端，
            // 言外之意，这些参数是默认规范
            RequestConfig defaultRequestConfig = RequestConfig.custom()
                    .setConnectTimeout(30000)
                    .setSocketTimeout(30000)
                    .setRedirectsEnabled(true)
                    .setConnectionRequestTimeout(3000)//请求最大时长3S,
                    .build();
            builder.setDefaultRequestConfig(defaultRequestConfig);
            builder.setMaxConnTotal(200);
            builder.setMaxConnPerRoute(128);//常量值
            builder.evictExpiredConnections();//过期移除
            builder.evictIdleConnections(60, TimeUnit.SECONDS);//空闲6秒移除
            restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory(builder.build()));
        };
    }




}
