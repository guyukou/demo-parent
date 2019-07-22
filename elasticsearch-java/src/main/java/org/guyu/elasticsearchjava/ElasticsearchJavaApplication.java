package org.guyu.elasticsearchjava;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetAddress;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.elasticsearch.index.query.QueryBuilders.boolQuery;
import static org.elasticsearch.index.query.QueryBuilders.termQuery;

@SpringBootApplication
public class ElasticsearchJavaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchJavaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Settings settings = Settings.builder()
                .put("cluster.name", "skywalking-cluster").build();
        Client client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new TransportAddress(InetAddress.getByName("10.32.32.11"), 9300));
        int scrollSize = 1000;
        Long endPointsRegisterTime = null;


        Set<String> endpoints = new HashSet<>();

        BoolQueryBuilder boolQueryBuilder = boolQuery();
        if (endPointsRegisterTime != null) {
            boolQueryBuilder.must().add(QueryBuilders.rangeQuery(EndpointInventory.REGISTER_TIME).gte(endPointsRegisterTime));
        }
        SearchResponse scrollResp = client.prepareSearch("endpoint_inventory")
                .addSort(FieldSortBuilder.DOC_FIELD_NAME, SortOrder.ASC)
                .setScroll(new TimeValue(60000))
                .setQuery(boolQueryBuilder)                 // Query
                .setSize(scrollSize)
                .get();

        do {
            for (SearchHit hit : scrollResp.getHits().getHits()) {
                Map<String, Object> sourceAsMap = hit.getSourceAsMap();

                endpoints.add((String) sourceAsMap.get(EndpointInventory.NAME));
            }

            scrollResp = client.prepareSearchScroll(scrollResp.getScrollId()).setScroll(new TimeValue(60000)).execute().actionGet();
        }
        while (scrollResp.getHits().getHits().length != 0); // Zero hits mark the end of the scroll and the while loop.
        System.out.println(endpoints);
        System.out.println(endpoints.size());

    }
}
