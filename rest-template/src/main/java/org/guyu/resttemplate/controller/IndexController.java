package org.guyu.resttemplate.controller;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;

/**
 * @author guyu
 * created at 2018/11/6 11:48 AM
 */
@RestController
@RequestMapping("/rest")
public class IndexController {
    @Autowired
    private RestTemplate restTemplate;
    private ExecutorService es = Executors.newCachedThreadPool();

    private LoadingCache<String, Integer> cache = CacheBuilder.newBuilder()
            .maximumSize(5)
            .refreshAfterWrite(3, TimeUnit.SECONDS)
            .build(new CacheLoader<String, Integer>() {
                @Override
                public Integer load(String s) throws Exception {
                    return s.hashCode();
                }

                @Override
                public ListenableFuture<Integer> reload(String key, Integer oldValue) throws Exception {
                    ListenableFutureTask<Integer> task = ListenableFutureTask.create(new Callable<Integer>() {
                        public Integer call() {
                            return compute(key, oldValue);
                        }
                    });
                    es.execute(task);
                    return task;
                }
            });

    private Integer compute(String s, Integer oldValue) {
        System.err.println("加载key=" + s);
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return s.hashCode() + oldValue;
    }

    @GetMapping("")
    public Integer index(@RequestParam("param") String param) {
        return cache.getUnchecked(param);
    }

    @GetMapping("/count")
    public Long getCount() {
        cache.refresh("qwer");
        return 1L;
    }
}
