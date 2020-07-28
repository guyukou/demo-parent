package org.guyu.springstatemachine;

import lombok.Data;

/**
 * @author guyu03 <guyu03@kuaishou.com>
 * Created on 2020-07-12
 */
@Data
public class Order {
    private int id;
    private OrderStatus status;
}
