package org.vance.goods.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.vance.goods.model.GoodsInfo;
import org.vance.goods.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.vance.goods.service.GoodsService;

@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @ApiOperation(value = "查找商品信息")
    @GetMapping("/queryGoodsInfo/{goodsId}")
    public Result queryGoodsInfo(@PathVariable("goodsId") Integer goodsId){
        GoodsInfo goodsInfo = goodsService.quertGoodsById(goodsId);
        return Result.success("success", goodsInfo);
    }
}
