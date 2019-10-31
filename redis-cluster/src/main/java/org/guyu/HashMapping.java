package org.guyu;

import org.guyu.entity.GoodsClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.hash.HashMapper;
import org.springframework.data.redis.hash.Jackson2HashMapper;
import org.springframework.data.redis.hash.ObjectHashMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author guyu
 * @date 2019-10-22
 */
@Component
public class HashMapping {

    @Resource(name = "redisTemplate")
    HashOperations<String, String, Object> hashOperations;

    HashMapper<Object, String, Object> mapper = new Jackson2HashMapper(false);

    public void writeHash(String key, GoodsClientDTO GoodsClientDTO) {
        Map<String, Object> mappedHash = mapper.toHash(GoodsClientDTO);

        hashOperations.putAll(key, mappedHash);
    }

    public GoodsClientDTO loadHash(String key) {

        Map<String, Object> loadedHash = hashOperations.entries(key);
        return (GoodsClientDTO) mapper.fromHash(loadedHash);
    }

    public GoodsClientDTO getName(String key, Collection<String> keys) {
        keys = new ArrayList<>(keys);
        keys.add("@class");
        List<Object> objects = hashOperations.multiGet(key, keys);
        Iterator<String> ki = keys.iterator();
        Iterator<Object> vi = objects.iterator();
        Map<String, Object> map = new HashMap<>();
        while (ki.hasNext() && vi.hasNext()) {
            map.put(ki.next(), vi.next());
        }

        return (GoodsClientDTO) mapper.fromHash(map);
    }
}
