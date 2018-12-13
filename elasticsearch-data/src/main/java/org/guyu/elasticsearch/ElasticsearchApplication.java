package org.guyu.elasticsearch;

import org.guyu.elasticsearch.repository.MessageEvent;
import org.guyu.elasticsearch.repository.extend.MessageEventExtend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

/**
 * @author guyu
 * created at 2018/12/3 4:23 PM
 */
@SpringBootApplication
public class ElasticsearchApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchApplication.class, args);
    }

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(elasticsearchTemplate.indexExists(MessageEventExtend.class));
        elasticsearchTemplate.createIndex(MessageEventExtend.class);

        elasticsearchTemplate.putMapping(MessageEventExtend.class);
    }
}
