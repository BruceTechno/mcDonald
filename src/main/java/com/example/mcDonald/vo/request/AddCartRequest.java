package com.example.mcDonald.vo.request;

public class AddCartRequest {
    private String userId;
    private int menuId;
    private int qty;
//==

    public AddCartRequest() {
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
}
