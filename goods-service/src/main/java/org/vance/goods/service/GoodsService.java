package org.vance.goods.service;

import org.springframework.stereotype.Service;
import org.vance.goods.model.GoodsInfo;

import java.util.HashMap;
import java.util.Map;

@Service
public class GoodsService {

    private static final Map<Integer, GoodsInfo> goodsMap = new HashMap<>();

    static {
        goodsMap.put(1, new GoodsInfo(1, "商品1", "描述1", 10, 11));
        goodsMap.put(2, new GoodsInfo(2, "商品2", "描述2", 20, 22));
        goodsMap.put(3, new GoodsInfo(3, "商品3", "描述3", 30, 33));
        goodsMap.put(4, new GoodsInfo(4, "商品4", "描述4", 40, 44));
        goodsMap.put(5, new GoodsInfo(5, "商品5", "描述5", 50, 55));
        goodsMap.put(6, new GoodsInfo(6, "商品6", "描述6", 60, 66));
        goodsMap.put(7, new GoodsInfo(7, "商品7", "描述7", 70, 77));

    }
    public GoodsInfo quertGoodsById(int id){
        return goodsMap.get(id);
    }
}
