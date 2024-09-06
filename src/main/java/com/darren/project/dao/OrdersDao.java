package com.darren.project.dao;

import com.darren.project.dto.OrdersRequest;
import com.darren.project.entity.Orders;

public interface OrdersDao {

    Orders getOrderByOrdersId(Integer ordersId);

    Integer createOrder(OrdersRequest ordersRequest);

    void deleteOrdersByOrdersId(Integer ordersId);
}
