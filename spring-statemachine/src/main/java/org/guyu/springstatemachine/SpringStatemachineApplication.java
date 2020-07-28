package org.guyu.springstatemachine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringStatemachineApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringStatemachineApplication.class, args);
    }
    @Autowired
    private OrderService orderService;

    @Override
    public void run(String... args) throws Exception {
        orderService.creat();
        orderService.creat();

        orderService.pay(1);

        new Thread(()->{
            orderService.deliver(1);
            orderService.receive(1);
        }).start();

        orderService.pay(2);
        orderService.deliver(2);
        orderService.receive(2);

        System.out.println(orderService.getOrders());
    }
}
