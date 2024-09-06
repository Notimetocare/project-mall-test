package com.darren.project.dao.Impl;

import com.darren.project.dao.OrdersDao;
import com.darren.project.dto.OrdersRequest;
import com.darren.project.entity.Orders;
import com.darren.project.mapper.OrdersRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.currentTimeMillis;

@Repository
public class OrdersDaoImpl implements OrdersDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public Orders getOrderByOrdersId(Integer ordersId) {
        String sql = "select id, order_date, status, total from orders where id = :id";

        Map<String, Object> map = new HashMap<>();
        map.put("id", ordersId);

        List<Orders> ordersList= namedParameterJdbcTemplate.query(sql, map, new OrdersRowMapper());

        if(ordersList.size()>0){
            return ordersList.get(0);
        }else {
            return null;
        }


    }

    @Override
    public Integer createOrder(OrdersRequest ordersRequest) {

        String sql = "insert into orders (order_date, status, total) values (:orderDate, :status, :total)";

        MapSqlParameterSource parameters = new MapSqlParameterSource();

        Timestamp now = new Timestamp(currentTimeMillis());

        parameters.addValue("orderDate",now);
        parameters.addValue("status", ordersRequest.getStatus());
        parameters.addValue("total",ordersRequest.getTotal());


        KeyHolder keyholder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, parameters,keyholder);
        int ordersId = keyholder.getKey().intValue();
        return ordersId;
    }
}
