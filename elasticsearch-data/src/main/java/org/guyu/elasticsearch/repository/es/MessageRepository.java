package org.guyu.elasticsearch.repository.es;

import org.guyu.elasticsearch.repository.Message;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface MessageRepository extends ElasticsearchRepository<Message, String> {


}
