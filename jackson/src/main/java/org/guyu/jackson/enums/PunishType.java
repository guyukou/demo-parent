package org.guyu.jackson.enums;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author guyu03 <guyu03@kuaishou.com>
 * Created on 2020-07-27
 */
@Getter
@RequiredArgsConstructor
public enum PunishType {
    PHOTO(1, "短视频"),
    LIVE(2, "直播"),
    PROFILE(3, "主页"),
    SEVERE_SCORE(8, "严重违规分"),

    ;
    private final int value;
    private final String desc;

    @JsonCreator
    public static PunishType from(int val) {
        return Arrays.stream(values())
                .filter(punishType -> punishType.getValue() == val)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(val + ""));
    }

    @JsonValue
    public int getValue() {
        return value;
    }
}
