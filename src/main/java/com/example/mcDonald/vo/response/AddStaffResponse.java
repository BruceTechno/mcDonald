package com.example.mcDonald.vo.response;

public class AddStaffResponse {
    private String message;
//==

    public AddStaffResponse() {
    }

    public AddStaffResponse(String message) {
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
