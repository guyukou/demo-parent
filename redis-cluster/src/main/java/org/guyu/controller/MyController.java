package org.guyu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author guyu
 * created at 2019-09-30 14:00
 */
@RequestMapping("/valid")
@RestController
public class MyController {

    private AtomicInteger atomicInteger = new AtomicInteger(0);
    @Autowired
    private StringRedisTemplate redisTemplate;
    private Random rand = new Random();

    @GetMapping("/performance")
    public Object performance() {
        return redisTemplate.opsForValue().get("abc" + rand.nextInt(200));
    }

    @GetMapping("/count")
    public Integer count() {
        return atomicInteger.get();
    }

    @GetMapping("/clear")
    public Integer clear() {
        atomicInteger.set(0);
        return atomicInteger.get();
    }


}
