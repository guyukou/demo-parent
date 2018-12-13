package org.guyu.elasticsearch.repository;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Document(indexName = "prod_pulse_message_201812", type = "pulse_message", shards = 3)
@Data
public class Message {
    /**
     * db 自动生成
     */
    @Id
    private String id;

    /**
     * 自增ID
     */
    private Integer qid;

    /**
     * 消息发送者定义的消息内容
     */
    @Field(type = FieldType.Keyword)
    private String content;

    /**
     * 接收者是谁
     */
    private Long clientUserId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 缓存超时时间，设置为 0 时不启用缓存，单位为秒
     */
    private Integer cacheTtl;


    /**
     * 接收用户使用的协议
     */
    @Field(type = FieldType.Keyword)
    private Protocol clientProtocol;

    /**
     * 业务方项目标识 appId
     */
    private Integer appId;

    /**
     * 业务方分配的ID
     */
    private Integer domain;


}
