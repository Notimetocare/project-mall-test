package com.darren.project.mapper;


import com.darren.project.entity.Orders;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class OrdersRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Orders orders = new Orders();

        orders.setId(rs.getInt("id"));

        Timestamp timestamp = rs.getTimestamp("order_date");
        orders.setOrderDate(timestamp.getTime());

        orders.setStatus(rs.getInt("status"));
        orders.setTotal(rs.getDouble("total"));

        return orders;
    }

    }

