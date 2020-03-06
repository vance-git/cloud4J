package org.vance.cart.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.vance.cart.model.GoodsInfo;

@Service
public class GoodsService {
    private RestTemplate restTemplate;

    public GoodsInfo queryById(int id){
        return this.restTemplate.getForObject("http://123.207.222.13:8081/goods/" + id, GoodsInfo.class);
    }
}
