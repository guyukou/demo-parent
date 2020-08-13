package org.guyu.jackson.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author guyu03 <guyu03@kuaishou.com>
 * Created on 2020-07-31
 */
@Getter
@AllArgsConstructor
public enum ScoreConfig {
    NORMAL(0, 20);
    private int min;
    private int max;

    public String outOfRange() {
        return String.format("一般违规分范围为%d-%d。", min, max);
    }
}
