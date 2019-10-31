package org.guyu.validation.web.config;

import org.guyu.validation.web.filter.AFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author guyu
 * @date 2019-10-22
 */
@Configuration
public class WebConfig {
    @Bean
    public FilterRegistrationBean registration(AFilter filter) {
        FilterRegistrationBean registration = new FilterRegistrationBean(filter);
        return registration;
    }
}
