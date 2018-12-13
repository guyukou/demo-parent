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
@Document(indexName = "prod_pulse_http_response_error_201812", type = "pulse_http_response_error", shards = 3)
public class HttpResponseError {
    /**
     * db 自动生成
     */
    @Id
    private String id;

    /**
     * 错误信息
     */
    @Field(type = FieldType.Keyword)
    private String message;

    /**
     * 主机名
     */
    @Field(type = FieldType.Keyword)
    private String hostname;

    /**
     * 事件发生时间
     */
    @Field(type = FieldType.Date,
            format = DateFormat.custom,
            pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZZ")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZZ")
    private Date eventTime;

}
