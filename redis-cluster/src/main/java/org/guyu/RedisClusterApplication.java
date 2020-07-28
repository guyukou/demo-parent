package org.guyu;

import lombok.extern.slf4j.Slf4j;
import org.guyu.entity.GoodsClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author guyu
 * created at 2018/11/13 11:24 AM
 */
@Slf4j
@SpringBootApplication
@RestController
@RequestMapping("/redis")
public class RedisClusterApplication implements CommandLineRunner {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private HashMapping hashMapping;

    public static void main(String[] args) {
        SpringApplication.run(RedisClusterApplication.class, args);
    }

    @Override
    public void run(String... args) {
//        GoodsClientDTO goodsClientDTO = new GoodsClientDTO();
//        redisTemplate.opsForValue().set("guyu", goodsClientDTO);
//        System.out.println(redisTemplate.opsForValue().get("guyu"));
        String[] split = "1384,1317,1316,1315,1314,1313,1312,1311,1309,1308,1307,1306,1305,1304,1303,1302,1301,1300,1299,1298,1297,1296,1295,1294,1293,1292,1291,1290,1289,1288,1287,1286,1285,1284,1283,1282,1281,1280,1279,1278".split(",");
        String prefix = "mid:goods:";
        List<String> collect = Arrays.stream(split).map(s -> prefix + s).collect(Collectors.toList());
//        redisTemplate.opsForValue().multiGet(collect);
        stringRedisTemplate.opsForValue().get("mid:goods:1278");
        redisTemplate.delete(collect);
        System.out.println();

    }

    @GetMapping("/iterate")
    public long iterate() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 3000; i++) {
            redisTemplate.opsForValue().set("xyz" + i, "xyz" + i, 1, TimeUnit.MINUTES);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    @GetMapping("/pipeline")
    public long pipeline() {
        long start = System.currentTimeMillis();
        redisTemplate.executePipelined((RedisCallback<Object>) connection -> {
            RedisSerializer<String> keySerializer = (RedisSerializer<String>) redisTemplate.getKeySerializer();
            RedisSerializer<Object> valueSerializer = (RedisSerializer<Object>) redisTemplate.getValueSerializer();
            for (int i = 0; i < 3000; i++) {
                connection.set(
                        keySerializer.serialize("xyz" + i),
                        valueSerializer.serialize("xyz" + i),
                        Expiration.from(1, TimeUnit.MINUTES),
                        RedisStringCommands.SetOption.UPSERT
                );
            }
            return null;
        });
        long end = System.currentTimeMillis();
        return end - start;
    }

    @GetMapping("/connection")
    public long connection() {
        long start = System.currentTimeMillis();
        redisTemplate.execute((RedisCallback<Object>) connection -> {
            RedisSerializer<String> keySerializer = (RedisSerializer<String>) redisTemplate.getKeySerializer();
            RedisSerializer<Object> valueSerializer = (RedisSerializer<Object>) redisTemplate.getValueSerializer();
            for (int i = 0; i < 3000; i++) {
                connection.set(
                        keySerializer.serialize("xyz" + i),
                        valueSerializer.serialize("xyz" + i),
                        Expiration.from(1, TimeUnit.MINUTES),
                        RedisStringCommands.SetOption.UPSERT
                );
            }
            return null;
        });
        long end = System.currentTimeMillis();
        return end - start;
    }
}
