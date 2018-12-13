package org.guyu.resttemplate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author guyu
 * created at 2018/11/6 11:48 AM
 */
@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping("")
    public String index() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        return "hello world";
    }
}
