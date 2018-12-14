package org.guyu.servicec2;

import org.springframework.stereotype.Service;

/**
 * @author guyu
 * created at 2018/12/13 4:15 PM
 */
@Service
public class ServiceN {
    public String n1() {
        System.out.println("dosth here");
        return "n1";
    }

    public String n2(RequestParam requestParam) {
        if (!requestParam.isIncludeAll()) {
            throw new UnsupportedOperationException("n2 方法暂未实现");
        }
        return "n2";
    }

}
