package com.darren.project.service;

import com.darren.project.dto.GoodsQueryParams;
import com.darren.project.dto.GoodsRequest;
import com.darren.project.entity.Goods;

import java.util.List;

public interface GoodsService {
    Goods getGoodsById(Integer goodsId);

    Integer createGoods(GoodsRequest goodsRequest);

    void deleteGoodsById(Integer goodsId);

    void updateGoods(Integer goodsId, GoodsRequest goodsRequest);

    List<Goods> getGoods(GoodsQueryParams params);

    Integer countGoods(GoodsQueryParams params);
}
