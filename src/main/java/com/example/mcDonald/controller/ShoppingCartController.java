package com.example.mcDonald.controller;

import com.example.mcDonald.service.ifs.ShoppingCartService;
import com.example.mcDonald.vo.request.AddCartRequest;
import com.example.mcDonald.vo.response.AddCartResponse;
import com.example.mcDonald.vo.response.GetShoppingCarResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;
    @PostMapping(value = "add_cart")
    public AddCartResponse addCart(@RequestBody AddCartRequest request, HttpSession session) {
        return shoppingCartService.addCart(request,session);
    }
    @GetMapping(value = "shopping_car_info")
    public GetShoppingCarResponse getShoppingCar(HttpSession session) {
        return shoppingCartService.getShoppingCar(session);
    }
}
