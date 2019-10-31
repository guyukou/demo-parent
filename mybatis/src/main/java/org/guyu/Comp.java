package org.guyu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author guyu
 * created at 2019-09-08 15:40
 */
@Component
public class Comp {
    @Value("${mybatis.mapper-locations}")
    private String s;

    public Comp() {
        System.out.println(s);
    }
}
