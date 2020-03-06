package org.vance.cart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vance.cart.model.beanModel.GoodsInfo;
import org.vance.cart.model.beanModel.Order;
import org.vance.cart.model.beanModel.OrderDetail;

import java.util.*;

@Service
public class ShoppingOrderService {
    private static final Map<String, Order> ORDER_DATA = new HashMap<String, Order>();

    static {
        Order order = new Order();
        order.setOrderId("201810300001");
        order.setCreateDate(new Date());
        order.setUpdateDate(order.getCreateDate());
        order.setUserId(1L);
        List<OrderDetail> orderDetails = new ArrayList<>();

        // 构造第一个商品数据
        GoodsInfo item = new GoodsInfo();
        item.setId(1);
        orderDetails.add(new OrderDetail(order.getOrderId(), item));

        // 构造第二个商品数据
        item = new GoodsInfo();
        item.setId(2);
        orderDetails.add(new OrderDetail(order.getOrderId(), item));

        order.setOrderDetails(orderDetails);

        ORDER_DATA.put(order.getOrderId(), order);
    }

    @Autowired
    private GoodsService goodsService;

    /**
     * 根据订单id查询订单数据
     *
     * @param orderId
     * @return
     */
    public Order queryOrderById(String orderId) {
        Order order = ORDER_DATA.get(orderId);
        if (null == order) {
            return null;
        }
        List<OrderDetail> orderDetails = order.getOrderDetails();
        for (OrderDetail orderDetail : orderDetails) {
            // 通过商品微服务查询商品详细数据
            GoodsInfo item = this.goodsService.queryById(orderDetail.getItem().getId());
            if (null == item) {
                continue;
            }
            orderDetail.setItem(item);
        }

        return order;
    }
}
