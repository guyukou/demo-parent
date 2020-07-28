package org.guyu.springstatemachine;

/**
 * @author guyu03 <guyu03@kuaishou.com>
 * Created on 2020-07-12
 */
public enum OrderStatusChangeEvent {
    // 支付，发货，确认收货
    PAYED, DELIVERY, RECEIVED;
}
