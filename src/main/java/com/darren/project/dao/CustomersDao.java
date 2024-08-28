package com.darren.project.dao;

import com.darren.project.dto.CustomersRegisterRequest;
import com.darren.project.entity.Customers;

import java.text.ParseException;

public interface CustomersDao {
    Integer creatCustomers(CustomersRegisterRequest customersRegisterRequest) throws ParseException;

    Customers getCustomersByCustomersId(Integer customersId);

    Customers getCustomersByphone(String phone);




}
