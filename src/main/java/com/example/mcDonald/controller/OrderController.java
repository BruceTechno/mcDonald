package com.example.mcDonald.controller;

import com.example.mcDonald.service.ifs.OrderService;
import com.example.mcDonald.vo.request.AddOrderRequest;
import com.example.mcDonald.vo.response.AddOrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping(value = "add_order")
    public AddOrderResponse addOrder(@RequestBody AddOrderRequest request, HttpSession session) {
        return orderService.addOrder(request, session);
    }
}
