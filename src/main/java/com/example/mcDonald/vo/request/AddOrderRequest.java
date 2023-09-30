package com.example.mcDonald.vo.request;

import com.example.mcDonald.entity.Order;

import java.util.List;

public class AddOrderRequest {
    private List<Order> orderList;
//==


    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
