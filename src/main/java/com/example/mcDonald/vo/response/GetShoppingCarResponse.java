package com.example.mcDonald.vo.response;

import com.example.mcDonald.entity.Menu;
import com.example.mcDonald.entity.ShoppingCart;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_DEFAULT)

public class GetShoppingCarResponse {
    private List<GetShoppingCarResponse> shoppingCarList;
    private String userId;
    private int menuId;
    private int qty;
    private String name;
    private String category;
    private int inventory;
    private int price;
    private int serveTime;
    private String description;
    private String img;
    private int sales;
    private int status;
    private String message;
//==

    public GetShoppingCarResponse() {
    }

    public GetShoppingCarResponse(List<GetShoppingCarResponse> shoppingCarList, String message) {
        this.shoppingCarList = shoppingCarList;
        this.message = message;
    }

    public GetShoppingCarResponse(String userId, int menuId, int qty, String name, String category, int inventory, int price, int serveTime, String description, String img, int sales, int status) {
        this.userId = userId;
        this.menuId = menuId;
        this.qty = qty;
        this.name = name;
        this.category = category;
        this.inventory = inventory;
        this.price = price;
        this.serveTime = serveTime;
        this.description = description;
        this.img = img;
        this.sales = sales;
        this.status = status;
    }

    public GetShoppingCarResponse(String message) {
        this.message = message;
    }

//==


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public List<GetShoppingCarResponse> getShoppingCarList() {
        return shoppingCarList;
    }

    public void setShoppingCarList(List<GetShoppingCarResponse> shoppingCarList) {
        this.shoppingCarList = shoppingCarList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
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

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
