package com.darren.project.dao.Impl;

import com.darren.project.dao.GoodsDao;
import com.darren.project.dto.GoodsRequest;
import com.darren.project.entity.Goods;
import com.darren.project.mapper.GoodsRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class GoodsDaoImpl implements GoodsDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Integer createGoods(GoodsRequest goodsRequest) {
        String sql = "insert into goods (name, price, description, brand, cpu_brand, cpu_type, memory_capacity, hd_capacity, card_model, displaysize, image) values (:name, :price, :description, :brand, :cpuBrand, :cpuType, :memoryCapacity, :hdCapacity, :cardModel, :displaysize, :image)";

        Map<String, Object> map = new HashMap<>();
        map.put("name",goodsRequest.getName());
        map.put("price",goodsRequest.getPrice());
        map.put("description",goodsRequest.getDescription());
        map.put("brand",goodsRequest.getBrand());
        map.put("cpuBrand",goodsRequest.getCpuBrand());
        map.put("cpuType",goodsRequest.getCpuType());
        map.put("memoryCapacity",goodsRequest.getMemoryCapacity());
        map.put("hdCapacity",goodsRequest.getHdCapacity());
        map.put("cardModel",goodsRequest.getCardModel());
        map.put("displaysize",goodsRequest.getDisplaysize());
        map.put("image",goodsRequest.getImage());

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map),keyHolder);

        int goodsId = keyHolder.getKey().intValue();
        return goodsId;
    }

    @Override
    public Goods getGoodsById(Integer goodsId) {

        String sql = "select id, name, price, description, brand, cpu_brand, cpu_type, memory_capacity, hd_capacity, card_model, displaysize, image from goods where id= :id";

        Map<String, Object> map = new HashMap<>();
        map.put("id", goodsId);
        List<Goods> goodsList = namedParameterJdbcTemplate.query(sql, map, new GoodsRowMapper());

        if(goodsList.size()>0){
            return goodsList.get(0);
        }else{
            return null;
        }

    }
}
