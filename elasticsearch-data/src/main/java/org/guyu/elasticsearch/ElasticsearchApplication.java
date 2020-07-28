package org.guyu.elasticsearch;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermsQueryBuilder;
import org.guyu.elasticsearch.repository.es.GoodsRepository;
import org.guyu.elasticsearch.repository.index.GoodsIndex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

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
    private GoodsRepository goodsRepository;

    @Override
    public void run(String... args) throws Exception {
//        searchByName("【蜂校中外双师】英语语法专练强化寒假班Level2");
        searchByMultiCondition();
    }

    private void findById(Long id) {
        Optional<GoodsIndex> goods = goodsRepository.findById(204L);
        goods.ifPresent(System.out::println);
    }

    private void searchByName(String name) {
        QueryBuilder query = QueryBuilders.matchQuery("name", name);
        Iterable<GoodsIndex> search = goodsRepository.search(query);
        search.forEach(System.out::println);
    }

    private void searchByMultiCondition() {
        int appGoodsId = 260;
        BoolQueryBuilder query = QueryBuilders.boolQuery()
                .must(QueryBuilders.matchQuery("name", "【蜂校中外双师】英语语法专练强化寒假班Level2"))
                .must(QueryBuilders.matchQuery("appGoodsId", appGoodsId));
        Iterable<GoodsIndex> search = goodsRepository.search(query);
        search.forEach(System.out::println);
    }
}
