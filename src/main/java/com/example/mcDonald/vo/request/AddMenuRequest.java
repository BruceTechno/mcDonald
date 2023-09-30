package com.example.mcDonald.vo.request;

public class AddMenuRequest {
    private String name;
    private int price;
    private int serveTime;
    private String description;
    private String img;
    private int status;
//==

    public AddMenuRequest() {
    }
//==


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getServeTime() {
        return serveTime;
    }

    public void setServeTime(int serveTime) {
        this.serveTime = serveTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


}
