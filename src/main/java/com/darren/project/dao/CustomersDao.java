package com.darren.project.dao;

import com.darren.project.dto.CustomersRegisterRequest;
import com.darren.project.entity.Customers;

public interface CustomersDao {
    Integer creatCustomers(CustomersRegisterRequest customersRegisterRequest);

    Customers getCustomersByCustomersId(Integer customersId);

    Customers getCustomersByphone(String phone);




}
