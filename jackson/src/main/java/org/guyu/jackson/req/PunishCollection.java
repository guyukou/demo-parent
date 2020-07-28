package org.guyu.jackson.req;

import java.util.List;

import lombok.Data;

/**
 * @author guyu03 <guyu03@kuaishou.com>
 * Created on 2020-07-27
 */
@Data
public class PunishCollection {
    private String violationDesc;
    private long ruleId;
    private List<PunishDetail> details;
}
