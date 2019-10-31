package org.guyu.validation.web;

import org.guyu.validation.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author guyu
 * created at 2019-09-30 14:00
 */
@RequestMapping("/valid")
@RestController
@Validated
public class MyController {

    @Autowired
    private Map<String, UserService> userServices;
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @GetMapping("/list")
    public Object hello(@Size(max = 3, message = "max 3 eles") @RequestParam("ids") List<Long> ids) {
        System.err.println(userServices);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("size", ids.size());
        return map;
    }

    @PostMapping("/write")
    public Object write() {
        return "abc";
    }

    @GetMapping("/performance")
    public Object performance() {
        atomicInteger.addAndGet(1);
        return "ok";
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
