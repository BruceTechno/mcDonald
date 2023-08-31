package com.example.mcDonald.vo.request;

public class DeleteMenuRequest {
    private int id;
    private int status;
//==

    public DeleteMenuRequest() {
    }
//==

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
