package com.darren.project.service;

import com.darren.project.dto.GoodsRequest;
import com.darren.project.entity.Goods;

public interface GoodsService {
    Goods getGoodsById(Integer goodsId);

    Integer createGoods(GoodsRequest goodsRequest);

    void deleteGoodsById(Integer goodsId);
}
