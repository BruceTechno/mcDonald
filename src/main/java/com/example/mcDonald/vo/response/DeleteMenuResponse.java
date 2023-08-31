package com.example.mcDonald.vo.response;

import com.example.mcDonald.entity.Menu;

public class DeleteMenuResponse {
    private Menu menu ;
    private String message;
//==

    public DeleteMenuResponse() {
    }

    public DeleteMenuResponse(String message) {
        this.message = message;
    }

    public DeleteMenuResponse(Menu menu, String message) {
        this.menu = menu;
        this.message = message;
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
