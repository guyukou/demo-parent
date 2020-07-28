package org.guyu.elasticsearch.repository.es;

import org.guyu.elasticsearch.repository.index.GoodsIndex;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author guyu
 * created at 2019-08-29 15:37
 */
public interface GoodsRepository extends ElasticsearchRepository<GoodsIndex, Long> {
}
