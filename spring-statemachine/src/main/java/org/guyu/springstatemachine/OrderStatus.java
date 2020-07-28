package org.guyu.springstatemachine;

/**
 * @author guyu03 <guyu03@kuaishou.com>
 * Created on 2020-07-12
 */
public enum OrderStatus {
    // 待支付，待发货，待收货，订单结束
    WAIT_PAYMENT, WAIT_DELIVER, WAIT_RECEIVE, FINISH;
}
