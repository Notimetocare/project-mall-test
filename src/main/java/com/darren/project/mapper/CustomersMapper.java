package com.darren.project.mapper;


import com.darren.project.entity.Customers;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomersMapper implements RowMapper<Customers> {
    @Override
    public Customers mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customers customers = new Customers();

        customers.setAccount((rs.getString("account")));
        customers.setName(rs.getString("name"));
        customers.setPassword(rs.getString("password"));
        customers.setAddress(rs.getString("address"));
        customers.setPhone(rs.getString("phone"));
        Long timestamp = rs.getLong("birthday");
        customers.setBirthday(timestamp);

        return customers;
    }
}
