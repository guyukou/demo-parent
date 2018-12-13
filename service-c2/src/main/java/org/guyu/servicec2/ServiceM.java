package org.guyu.servicec2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author guyu
 * created at 2018/12/13 4:15 PM
 */
@Service
public class ServiceM {

    @Autowired
    private ServiceN serviceN;
    public String m1(boolean includeErr) {
        if (!includeErr) {
            return serviceN.n1();
        } else {
            return serviceN.n2();
        }
    }
}
