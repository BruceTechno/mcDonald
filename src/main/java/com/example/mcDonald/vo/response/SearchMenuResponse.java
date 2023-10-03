package com.example.mcDonald.vo.response;

import com.example.mcDonald.entity.Menu;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_DEFAULT)

public class SearchMenuResponse {
    private List<Menu> menuList;
    private Menu menu;
    private String message;
    private List<String> categoryList;
//==

    public SearchMenuResponse(String message, List<String> categoryList) {
        this.message = message;
        this.categoryList = categoryList;
    }

    public SearchMenuResponse(String message) {
        this.message = message;
    }

    public SearchMenuResponse(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public SearchMenuResponse() {
    }

    public SearchMenuResponse(List<Menu> menuList, String message) {
        this.menuList = menuList;
        this.message = message;
    }

    public SearchMenuResponse(Menu menu, String message) {
        this.menu = menu;
        this.message = message;
    }
    //==

    public List<String> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<String> categoryList) {
        this.categoryList = categoryList;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
