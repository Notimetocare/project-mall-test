package com.darren.project.service;

import com.darren.project.dto.CustomerLoginRequest;
import com.darren.project.dto.CustomersRegisterRequest;
import com.darren.project.entity.Customers;

import java.text.ParseException;

public interface CustomerService {
    Integer register(CustomersRegisterRequest customersRegisterRequest) throws ParseException, ParseException;

    Customers getCustomersById(Integer customersId);


    Customers getCustomersByAccount(String account);

    Customers login(CustomerLoginRequest customersLoginRequest);
}