package org.vance.cart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.vance.cart.model.beanModel.GoodsInfo;

@Service
public class GoodsService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${goods.cloud.url}")
    private String goodsUrl;

    public GoodsInfo queryById(int id){
        System.out.println("id : " + id);
        GoodsInfo goodsInfo = restTemplate.getForObject(goodsUrl + id, GoodsInfo.class);
        System.out.println("goodsInfo : " + goodsInfo.toString());
        return goodsInfo;
    }
}
