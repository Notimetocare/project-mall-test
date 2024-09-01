package com.darren.project.controller;

import com.darren.project.dto.GoodsRequest;
import com.darren.project.entity.Goods;
import com.darren.project.service.GoodsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @GetMapping("goods/{goodsId}")
    public ResponseEntity<Goods> getGoods(@PathVariable Integer goodsId){
       Goods goods = goodsService.getGoodsById(goodsId);

       if(goods != null){
           return ResponseEntity.status(HttpStatus.OK).body(goods);
       }else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
    }

    @PostMapping("goods")
    public ResponseEntity<Goods> createGoods(@RequestBody @Valid GoodsRequest goodsRequest){
        Integer goodsId = goodsService.createGoods(goodsRequest);

        Goods goodsById = goodsService.getGoodsById(goodsId);

        if(goodsById != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(goodsById);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }


}
