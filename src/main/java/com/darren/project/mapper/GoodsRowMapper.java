package com.darren.project.mapper;

import com.darren.project.entity.Goods;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GoodsRowMapper implements RowMapper {
    @Override
    public Goods mapRow(ResultSet rs, int rowNum) throws SQLException {
        Goods goods = new Goods();

        goods.setId(rs.getInt("id"));
        goods.setName(rs.getString("name"));
        goods.setPrice(rs.getDouble("price"));
        goods.setDescription(rs.getString("description"));
        goods.setCpuBrand(rs.getString("cpu_Brand"));
        goods.setBrand(rs.getString("brand"));
        goods.setCpuType(rs.getString("cpu_type"));
        goods.setMemoryCapacity(rs.getString("memory_capacity"));
        goods.setHdCapacity(rs.getString("hd_capacity"));
        goods.setCardModel(rs.getString("card_model"));
        goods.setDisplaysize(rs.getString("displaysize"));
        goods.setImage(rs.getString("image"));

        return goods;
    }
}
