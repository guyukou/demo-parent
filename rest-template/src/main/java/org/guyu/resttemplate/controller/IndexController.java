package org.guyu.resttemplate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author guyu
 * created at 2018/11/6 11:48 AM
 */
@RestController
@RequestMapping("/rest")
public class IndexController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("")
    public Integer index() {
        return restTemplate.getForObject("http://localhost:10000/valid/count", Integer.class);
    }
}
