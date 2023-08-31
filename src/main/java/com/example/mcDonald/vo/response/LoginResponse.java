package com.example.mcDonald.vo.response;

import com.example.mcDonald.entity.Staff;

public class LoginResponse {
    private Staff staff;
    private String message;
//==

    public LoginResponse() {
    }

    public LoginResponse(String message) {
        this.message = message;
    }

    public LoginResponse(Staff staff, String message) {
        this.staff = staff;
        this.message = message;
    }
    //==

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
