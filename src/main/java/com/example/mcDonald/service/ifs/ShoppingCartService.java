package com.example.mcDonald.service.ifs;

import com.example.mcDonald.vo.request.AddCartRequest;
import com.example.mcDonald.vo.response.AddCartResponse;
import com.example.mcDonald.vo.response.GetShoppingCarResponse;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface ShoppingCartService {
    public AddCartResponse addCart(AddCartRequest request , HttpSession session);
    public GetShoppingCarResponse getShoppingCar(HttpSession session);
}
