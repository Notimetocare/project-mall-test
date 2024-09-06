package com.darren.project.service.Impl;

import com.darren.project.dao.OrdersDao;
import com.darren.project.dto.OrdersRequest;
import com.darren.project.entity.Orders;
import com.darren.project.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrdersDao ordersDao;
    @Override
    public Orders getOrderById(Integer ordersId) {
        return ordersDao.getOrderByOrdersId(ordersId);
    }

    @Override
    public Integer createOrders(OrdersRequest ordersRequest) {
        return ordersDao.createOrder(ordersRequest);
    }
}
