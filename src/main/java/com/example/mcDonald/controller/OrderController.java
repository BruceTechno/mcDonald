package com.example.mcDonald.controller;

import com.example.mcDonald.service.ifs.OrderService;
import com.example.mcDonald.vo.request.AddOrderRequest;
import com.example.mcDonald.vo.response.AddOrderResponse;
import com.example.mcDonald.vo.response.GetMenuFromOrderByConsumerId;
import com.example.mcDonald.vo.response.SearchOrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping(value = "order_by_consumerId")
    public SearchOrderResponse searchOrderByConsumerId(HttpSession session) {
        return orderService.searchOrderByConsumerId(session);
    }
    @GetMapping(value = "menu_from_order_by_consumer_id")
    public GetMenuFromOrderByConsumerId menuByConsumerId(HttpSession session) {
        return orderService.menuByConsumerId(session);
    }
    }
