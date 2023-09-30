package com.example.mcDonald.vo.response;

import com.example.mcDonald.entity.Order;

import java.util.List;

public class AddOrderResponse {
    private String message;
    private List<Order> orderList;
//==


    public AddOrderResponse() {
    }

    public AddOrderResponse(String message) {
        this.message = message;
    }

    public AddOrderResponse(String message, List<Order> orderList) {
        this.message = message;
        this.orderList = orderList;
    }
//==

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
