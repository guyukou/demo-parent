package org.guyu.elasticsearch.repository;

public enum Protocol {
    TCP,
    WEBSOCKET;

    public static Protocol fromName(String name) {
        for (Protocol value : values()) {
            if (value.name().equals(name)) {
                return value;
            }
        }
        throw new IllegalArgumentException("unrecognized name: " + name);

    }
}
