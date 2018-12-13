package org.guyu.elasticsearch.repository;

public enum MessageEventType {
    CREATED, // 消息被接收且持久化
    PUSHED, // 消息被推送客户端
    RECEIVED, // 消息被客户端接收
    NO_SOCKET, // 因无可用连接不被送达
    CACHED, // 消息被缓存
    EXPIRED, // 消息的缓存到期
    OVERRIDDEN,  // 消息在缓存期间被新消息覆盖
}
