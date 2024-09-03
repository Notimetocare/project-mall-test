package com.darren.project.dao.Impl;

import com.darren.project.dao.GoodsDao;
import com.darren.project.dto.GoodsQueryParams;
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
    public Integer countGoods(GoodsQueryParams params) {
        String sql = "select count(*) from goods where 1=1";

        Map<String, Object> map = new HashMap<>();

        sql = addFilteringsql(sql, map, params);

        Integer total = namedParameterJdbcTemplate.queryForObject(sql, map, Integer.class);

        return total;
    }

    @Override
    public Integer createGoods(GoodsRequest goodsRequest) {
        String sql = "insert into goods (name, price, description, brand, cpu_brand, cpu_type, memory_capacity, hd_capacity, card_model, displaysize, image) values (:name, :price, :description, :brand, :cpuBrand, :cpuType, :memoryCapacity, :hdCapacity, :cardModel, :displaysize, :image)";

        Map<String, Object> map = new HashMap<>();
        map.put("name", goodsRequest.getName());
        map.put("price", goodsRequest.getPrice());
        map.put("description", goodsRequest.getDescription());
        map.put("brand", goodsRequest.getBrand());
        map.put("cpuBrand", goodsRequest.getCpuBrand());
        map.put("cpuType", goodsRequest.getCpuType());
        map.put("memoryCapacity", goodsRequest.getMemoryCapacity());
        map.put("hdCapacity", goodsRequest.getHdCapacity());
        map.put("cardModel", goodsRequest.getCardModel());
        map.put("displaysize", goodsRequest.getDisplaysize());
        map.put("image", goodsRequest.getImage());

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        int goodsId = keyHolder.getKey().intValue();
        return goodsId;
    }

    @Override
    public Goods getGoodsById(Integer goodsId) {

        String sql = "select id, name, price, description, brand, cpu_brand, cpu_type, memory_capacity, hd_capacity, card_model, displaysize, image from goods where id= :id";

        Map<String, Object> map = new HashMap<>();
        map.put("id", goodsId);
        List<Goods> goodsList = namedParameterJdbcTemplate.query(sql, map, new GoodsRowMapper());

        if (goodsList.size() > 0) {
            return goodsList.get(0);
        } else {
            return null;
        }

    }

    @Override
    public void deleteGoodsById(Integer goodsId) {
        String sql = "delete from goods where id = :id";
        Map<String, Object> map = new HashMap<>();

        map.put("id", goodsId);

        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public void updateGoodsById(Integer goodsId, GoodsRequest goodsRequest) {
        String sql = "update goods set name = :name, price = :price, description = :description, brand = :brand, cpu_brand = :cpuBrand, cpu_type = :cpuType, memory_capacity = :memoryCapacity, hd_capacity = :hdCapacity, card_model = :cardModel, displaysize = :displaysize, image = :image where id = :id";

        Map<String, Object> map = new HashMap<>();
        map.put("id", goodsId);
        map.put("name", goodsRequest.getName());
        map.put("price", goodsRequest.getPrice());
        map.put("description", goodsRequest.getDescription());
        map.put("brand", goodsRequest.getBrand());
        map.put("cpuBrand", goodsRequest.getCpuBrand());
        map.put("cpuType", goodsRequest.getCpuType());
        map.put("memoryCapacity", goodsRequest.getMemoryCapacity());
        map.put("hdCapacity", goodsRequest.getHdCapacity());
        map.put("cardModel", goodsRequest.getCardModel());
        map.put("displaysize", goodsRequest.getDisplaysize());
        map.put("image", goodsRequest.getImage());

        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public List<Goods> getGoods(GoodsQueryParams params) {
        String sql = "select id, name, price, description, brand, cpu_brand, cpu_type, memory_capacity, hd_capacity, card_model, displaysize, image from goods where 1 = 1";

        Map<String, Object> map = new HashMap<>();
        //查詢
        sql = addFilteringsql(sql, map, params);
        //排序
        sql = sql + " order by "+ params.getOrderBy() + " " + params.getSort();
        //分頁
        sql = sql + " limit :limit offset :offset";
        map.put("limit",params.getLimit());
        map.put("offset",params.getOffset());

        List<Goods> goodslist = namedParameterJdbcTemplate.query(sql,map, new GoodsRowMapper());
        return goodslist;
    }
    private String addFilteringsql(String sql, Map<String, Object> map, GoodsQueryParams params){
        if(params.getSearch() != null){
            sql = sql + " and (name like :search )";
            map.put("search", "%" + params.getSearch() + "%");
        }
        return sql;
    }

}
