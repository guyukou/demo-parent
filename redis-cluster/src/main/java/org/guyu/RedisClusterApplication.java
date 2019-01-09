package org.guyu;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;

import java.util.HashSet;
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
        Set<String> execute = redisTemplate.execute((RedisCallback<Set<String>>) connection -> {

            Set<String> binaryKeys = new HashSet<>();

            Cursor<byte[]> cursor = connection.scan(new ScanOptions.ScanOptionsBuilder().match("websocket|uid*").count(2000).build());
            while (cursor.hasNext()) {
                binaryKeys.add(new String(cursor.next()));
            }
            return binaryKeys;
        });
        System.out.println(execute);

    }
}
