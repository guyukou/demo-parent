package org.guyu;

import lombok.extern.slf4j.Slf4j;
import org.guyu.domain.d0.GoodsDO;
import org.guyu.domain.d0.TJsonDO;
import org.guyu.mapper.GoodsMapper;
import org.guyu.mapper.TJsonMapper;
import org.guyu.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Map;

/**
 * spring boot entry class
 *
 * @author guyu
 * created at 2019-08-14 20:14
 */
@Slf4j
@SpringBootApplication
public class MybatisApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
    }

    @Autowired
    private TJsonMapper tJsonMapper;
    @Autowired
    private GoodsMapper goodsMapper;


    @Override
    public void run(String... args) throws Exception {
        boolean exists = goodsMapper.exists(1000L);
        System.out.println(exists);
        exists = goodsMapper.exists(10000L);
        System.out.println(exists);
    }

    private void testGoods(Map<String, Object> map) {
        GoodsDO goodsDO = new GoodsDO();
        goodsDO.setAttrs(JsonUtils.toString(map));
        goodsDO.setAppGoodsId(System.currentTimeMillis());
        goodsDO.setStatus((byte) 1);

        goodsMapper.insert(goodsDO);
    }
    private void testTJson(Map<String, Object> map) {
        TJsonDO tJsonDO = new TJsonDO();
        tJsonDO.setCJson(JsonUtils.toString(map));
        tJsonDO.setCVarchar(JsonUtils.toString(map));
        tJsonMapper.insert(tJsonDO);
        List<TJsonDO> tJsonDOS = tJsonMapper.selectAll();
        System.out.println(tJsonDOS);

    }
}

