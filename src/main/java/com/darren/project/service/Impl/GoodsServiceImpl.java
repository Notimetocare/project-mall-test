package com.darren.project.service.Impl;

import com.darren.project.dao.GoodsDao;
import com.darren.project.dto.GoodsRequest;
import com.darren.project.entity.Goods;
import com.darren.project.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;
    @Override
    public Goods getGoodsById(Integer goodsId) {
        return goodsDao.getGoodsById(goodsId);
    }

    @Override
    public Integer createGoods(GoodsRequest goodsRequest) {
        return goodsDao.createGoods(goodsRequest);
    }
}
