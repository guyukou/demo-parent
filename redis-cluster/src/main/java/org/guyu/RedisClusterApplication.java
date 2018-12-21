package org.guyu;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;
import java.util.Set;

/**
 * @author guyu
 * created at 2018/11/13 11:24 AM
 */
@Slf4j
@SpringBootApplication
public class RedisClusterApplication implements CommandLineRunner {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public static void main(String[] args) {
        SpringApplication.run(RedisClusterApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Set<String> keys = redisTemplate.keys("websocket|uid:*");
        for (String key : keys) {
            Map<Object, Object> entries = redisTemplate.opsForHash().entries(key);
            for (Map.Entry<Object, Object> entry : entries.entrySet()) {
                if (!entry.getValue().toString().startsWith("[")) {
                    System.out.format("key:%s, key2: %s, value:%s", key, entry.getKey(), entry.getValue());
                }
            }

        }

    }
}
