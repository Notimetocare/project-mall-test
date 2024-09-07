package com.darren.project.dao.Impl;

import com.darren.project.dao.CustomersDao;
import com.darren.project.dto.CustomersRegisterRequest;
import com.darren.project.entity.Customers;
import com.darren.project.mapper.CustomersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CustomersDaoImpl implements CustomersDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public Integer creatCustomers(CustomersRegisterRequest customersRegisterRequest){
        String sql = "INSERT INTO customers(Account, name, password, address, phone, birthday) VALUES(:account, :name, :password, :address, :phone, :birthday)";
        Map<String, Object> map = new HashMap<>();
        map.put("account", customersRegisterRequest.getAccount());
        map.put("name",customersRegisterRequest.getName());
        map.put("password", customersRegisterRequest.getPassword());
        map.put("address",customersRegisterRequest.getAddress());
        map.put("phone",customersRegisterRequest.getPhone());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date birthday = simpleDateFormat.parse(customersRegisterRequest.getBirthday());
            Long timestamp = birthday.getTime();
            map.put("birthday",timestamp);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);
        int UserId = keyHolder.getKey().intValue();
        return UserId;
    }

    @Override
    public Customers getCustomersByCustomersId(Integer customersId) {
        String sql = "SELECT id, Account, name, password, address, phone, birthday from customers where id = :id";

        Map<String, Object> map = new HashMap<>();
        map.put("id",customersId);

        List<Customers> customersList = namedParameterJdbcTemplate.query(sql,map,new CustomersMapper());
        if(customersList.size()>0){
            return customersList.get(0);
        }else{
            return null;
        }

    }

        @Override
        @Transactional
    public Customers getCustomersByAccount(String account) {
        String sql = "select id, Account, name, password, address, phone, birthday from customers where Account = :account";

            Map<String, Object> map = new HashMap<>();
            map.put("account",account);

            List<Customers> customersList = namedParameterJdbcTemplate.query(sql, map, new CustomersMapper());
            return !customersList.isEmpty()?customersList.get(0): null;

        }
}
