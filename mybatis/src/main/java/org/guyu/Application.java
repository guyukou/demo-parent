package org.guyu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

/**
 * spring boot entry class
 *
 * @author guyu
 * created at 2019-08-14 20:14
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private Comp comp;

    @Override
    public void run(String... args) throws Exception {
        System.out.println();
    }
}

