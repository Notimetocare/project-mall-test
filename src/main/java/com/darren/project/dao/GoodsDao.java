package com.darren.project.dao;

import com.darren.project.dto.GoodsQueryParams;
import com.darren.project.dto.GoodsRequest;
import com.darren.project.entity.Goods;

import java.util.List;

public interface GoodsDao {
    Integer countGoods(GoodsQueryParams params);
    Integer createGoods(GoodsRequest goodsRequest);

    Goods getGoodsById(Integer goodsId);

    void deleteGoodsById(Integer goodsId);

    void updateGoodsById(Integer goodsId, GoodsRequest goodsRequest);

    List<Goods> getGoods(GoodsQueryParams params);
}
