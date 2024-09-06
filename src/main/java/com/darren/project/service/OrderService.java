package com.darren.project.service;

import com.darren.project.dto.OrdersRequest;
import com.darren.project.entity.Orders;

public interface OrderService {
    Orders getOrderById(Integer ordersId);

    Integer createOrders(OrdersRequest ordersRequest);
}
