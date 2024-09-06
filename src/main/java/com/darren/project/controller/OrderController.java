package com.darren.project.controller;

import com.darren.project.dto.OrdersRequest;
import com.darren.project.entity.Orders;
import com.darren.project.service.OrderService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("orders/{ordersId}")
    public ResponseEntity<Orders> getOrders(@PathVariable Integer ordersId){

        Orders orders = orderService.getOrderById(ordersId);

        if(orders != null){
            return ResponseEntity.status(HttpStatus.OK).body(orders);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @PostMapping("orders")
    public ResponseEntity<Orders> createOrder(@Valid@RequestBody OrdersRequest ordersRequest){
        Integer ordersId = orderService.createOrders(ordersRequest);

        Orders orders = orderService.getOrderById(ordersId);

        return ResponseEntity.status(HttpStatus.CREATED).body(orders);

    }




}
