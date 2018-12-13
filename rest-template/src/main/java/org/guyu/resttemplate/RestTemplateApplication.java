package org.guyu.resttemplate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author guyu
 * created at 2018/11/6 11:38 AM
 */
@SpringBootApplication
@Slf4j
public class RestTemplateApplication  {
    public static void main(String[] args) {
        SpringApplication.run(RestTemplateApplication.class, args);
    }
}