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
@Document(indexName = "prod_pulse_domain_conn_201812", type = "pulse_domain_conn", shards = 3)
public class DomainConnStat {
    @Id
    private String id;

    private Integer count;

    @Field(type = FieldType.Keyword)
    private String appName;

    @Field(type = FieldType.Keyword)
    private String hostName;

    @Field(type = FieldType.Keyword)
    private Protocol protocol;

    @Field(type = FieldType.Date,
            format = DateFormat.custom,
            pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZZ")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZZ")
    private Date timestamp;
}
