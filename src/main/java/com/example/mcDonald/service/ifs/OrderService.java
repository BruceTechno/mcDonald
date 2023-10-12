package com.example.mcDonald.service.ifs;

import com.example.mcDonald.vo.request.AddOrderRequest;
import com.example.mcDonald.vo.response.AddOrderResponse;
import com.example.mcDonald.vo.response.GetMenuFromOrderByConsumerId;
import com.example.mcDonald.vo.response.SearchOrderResponse;

import javax.servlet.http.HttpSession;

public interface OrderService {
    public AddOrderResponse addOrder (AddOrderRequest request , HttpSession session);
    public SearchOrderResponse searchOrderByConsumerId(HttpSession session);
    public GetMenuFromOrderByConsumerId menuByConsumerId(HttpSession session);

}
