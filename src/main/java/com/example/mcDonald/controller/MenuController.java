package com.example.mcDonald.controller;

import com.example.mcDonald.service.ifs.MenuService;
import com.example.mcDonald.vo.request.AddMenuRequest;
import com.example.mcDonald.vo.request.DeleteMenuRequest;
import com.example.mcDonald.vo.request.SearchMenuRequest;
import com.example.mcDonald.vo.response.AddMenuResponse;
import com.example.mcDonald.vo.response.DeleteMenuResponse;
import com.example.mcDonald.vo.response.SearchMenuResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin
public class MenuController {
    @Autowired
    private MenuService menuService;

    @PostMapping(value = "add_menu")
    public AddMenuResponse addMenu(@RequestBody AddMenuRequest request, HttpSession session) {
        return menuService.addMenu(request, session);
    }
    @PostMapping(value = "delete_menu")
    public DeleteMenuResponse deleteMenu(@RequestBody DeleteMenuRequest request, HttpSession session) {
        return menuService.deleteMenu(request,session);
    }
    @GetMapping(value = "all_menu")
    public SearchMenuResponse allMenu() {
        return menuService.allMenu();
    }
    @PostMapping(value = "search_menu_distinctly")
    public SearchMenuResponse searchMenuDistinctly(@RequestBody SearchMenuRequest request) {
        return menuService.searchMenuDistinctly(request);
    }
    @PostMapping(value = "search_top_menu")
    public SearchMenuResponse searchBestSellingMenu(@RequestBody SearchMenuRequest request) {
        return menuService.searchBestSellingMenu(request);
    }


}
