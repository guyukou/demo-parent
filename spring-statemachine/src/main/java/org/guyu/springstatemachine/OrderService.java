package org.guyu.springstatemachine;

import java.util.Map;

/**
 * @author guyu03 <guyu03@kuaishou.com>
 * Created on 2020-07-12
 */
public interface OrderService {
    Order creat();
    Order pay(int id);
    Order deliver(int id);
    Order receive(int id);
    Map<Integer, Order> getOrders();
}
