package org.vance.cart.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.vance.cart.model.Order;
import org.vance.cart.service.ShoppingOrderService;

@RestController
public class ShoppingCartController {

    @Autowired
    private ShoppingOrderService orderService;

    @ApiOperation(value = "查询订单")
    @GetMapping(value = "order/{orderId}")
    public Order queryOrderById(@PathVariable("orderId") String orderId) {
        return this.orderService.queryOrderById(orderId);
    }
}
