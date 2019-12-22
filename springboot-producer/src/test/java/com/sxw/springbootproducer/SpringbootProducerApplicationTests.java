package com.sxw.springbootproducer;

import com.sxw.entity.Order;
import com.sxw.springbootproducer.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootProducerApplicationTests {
    @Autowired
    private OrderService orderService;

    @Test
    public void testSend() throws Exception {
        Order order = new Order();
        order.setId(Integer.parseInt(getOrderIdByTime()));
        order.setName("测试订单1");
        order.setMessageId(System.currentTimeMillis() + "$" + UUID.randomUUID().toString());
        orderService.createOrder(order);
    }

    public static String getOrderIdByTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String newDate = sdf.format(new Date());
        String result = "";
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            result += random.nextInt(10);
        }
        return newDate + result;
    }

}
