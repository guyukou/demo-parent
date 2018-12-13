package org.guyu.elasticsearch.repository.extend;

import org.guyu.elasticsearch.repository.MessageEvent;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author guyu
 * created at 2018/12/3 5:19 PM
 */
@Document(indexName = "#{indexPrefix.prefix}pulse_message_event_#{indexSuffix.suffix}", type = "pulse_message_event", shards = 3)
public class MessageEventExtend extends MessageEvent {
}
