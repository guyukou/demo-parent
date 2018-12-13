package org.guyu.elasticsearch.repository;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(indexName = "prod_pulse_connection_event_201812", type = "pulse_connection_event", shards = 3)
public class ConnEvent {
    /**
     * db 自动生成
     */
    @Id
    private String id;

    /**
     * 所属连接的 id
     */
    @Field(type = FieldType.Keyword)
    private String connectionId;

    /**
     * 事件发生时间
     */
    @Field(type = FieldType.Date,
            format = DateFormat.custom,
            pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZZ")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZZ")
    private Date eventTime;

    /**
     * 事件类型
     */
    @Field(type = FieldType.Keyword)
    private ConnEventType connEventType;

    /**
     * 事件的关联消息 id，可以为空字符串
     */
    @Field(type = FieldType.Keyword)
    private String messageId;
}
