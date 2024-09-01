package com.darren.project.dao;

import com.darren.project.dto.GoodsRequest;
import com.darren.project.entity.Goods;

public interface GoodsDao {
    Integer createGoods(GoodsRequest goodsRequest);

    Goods getGoodsById(Integer goodsId);

    void deleteGoodsById(Integer goodsId);
}
