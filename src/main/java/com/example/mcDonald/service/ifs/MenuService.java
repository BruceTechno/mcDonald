package com.example.mcDonald.service.ifs;

import com.example.mcDonald.vo.request.AddMenuRequest;
import com.example.mcDonald.vo.request.DeleteMenuRequest;
import com.example.mcDonald.vo.response.AddMenuResponse;
import com.example.mcDonald.vo.response.DeleteMenuResponse;

import javax.servlet.http.HttpSession;

public interface MenuService {
    public AddMenuResponse addMenu (AddMenuRequest request , HttpSession session);
    public DeleteMenuResponse deleteMenu (DeleteMenuRequest request, HttpSession session);
}
