package com.example.mcDonald.vo.response;

import com.example.mcDonald.entity.Punch;
import com.example.mcDonald.entity.Staff;

public class PunchInResponse {
    private String message;
    private Punch punch;
    private Staff staff;
//==


    public PunchInResponse() {
    }

    public PunchInResponse(String message) {
        this.message = message;
    }

    public PunchInResponse(String message, Punch punch) {
        this.message = message;
        this.punch = punch;
    }

    public PunchInResponse(String message, Punch punch, Staff staff) {
        this.message = message;
        this.punch = punch;
        this.staff = staff;
    }
    //==

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Punch getPunch() {
        return punch;
    }

    public void setPunch(Punch punch) {
        this.punch = punch;
    }
}
