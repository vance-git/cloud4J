package org.vance.cart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.vance.cart.model.GoodsInfo;

@Service
public class GoodsService {
    @Autowired
    private RestTemplate restTemplate;

    public GoodsInfo queryById(int id){
        System.out.println("id : " + id);
        GoodsInfo goodsInfo = restTemplate.getForObject("http://127.0.0.1:8081/goods/queryGoodsInfo/" + id, GoodsInfo.class);
        System.out.println("goodsInfo : " + goodsInfo.toString());
        return goodsInfo;
    }
}
