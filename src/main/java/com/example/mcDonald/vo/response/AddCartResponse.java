package com.example.mcDonald.vo.response;

public class AddCartResponse {
    private String message;
//==

    public AddCartResponse() {
    }

    public AddCartResponse(String message) {
        this.message = message;
    }
//==

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
