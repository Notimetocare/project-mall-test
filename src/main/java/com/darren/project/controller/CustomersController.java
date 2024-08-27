package com.darren.project.controller;

import com.darren.project.dto.CustomersRegisterRequest;
import com.darren.project.entity.Customers;
import com.darren.project.service.CustomerSerivce;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomersController {
    @Autowired
    private CustomerSerivce customerSerivce;

    @PostMapping("customers/register")
    public ResponseEntity<Customers> register(@RequestBody @Valid CustomersRegisterRequest customersRegisterRequest) {
        Integer customersId = customerSerivce.register(customersRegisterRequest);

        Customers customers = customerSerivce.getCustomersById(customersId);

        return ResponseEntity.status(HttpStatus.CREATED).body(customers);
    }

}
