package com.darren.project.mapper;


import com.darren.project.entity.Customers;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomersMapper implements RowMapper<Customers> {
    @Override
    public Customers mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customers customers = new Customers();

        customers.setId(rs.getInt("id"));
        customers.setName(rs.getString("name"));
        customers.setPassword(rs.getString("password"));
        customers.setAddress(rs.getString("address"));
        customers.getBirthday(rs.getTimestamp("birthday"));

        return customers;
    }
}
