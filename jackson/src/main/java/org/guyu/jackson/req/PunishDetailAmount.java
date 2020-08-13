package org.guyu.jackson.req;

import org.guyu.jackson.model.AmountDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author guyu03 <guyu03@kuaishou.com>
 * Created on 2020-07-27
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PunishDetailAmount extends PunishDetail {
    private AmountDTO param;
}
