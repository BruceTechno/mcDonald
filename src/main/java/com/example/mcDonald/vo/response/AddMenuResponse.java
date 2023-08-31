package com.example.mcDonald.vo.response;

import com.example.mcDonald.entity.Menu;

public class AddMenuResponse {
    private String message;
    private Menu menu;
//==

    public AddMenuResponse() {
    }

    public AddMenuResponse(String message) {
        this.message = message;
    }

    public AddMenuResponse(String message, Menu menu) {
        this.message = message;
        this.menu = menu;
    }
    //==

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
