package com.example.mcDonald.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class GetMenuFromOrderByConsumerId {
    //order
    private int orderId;
    //menu
    private String name;
    private int qty;
    private LocalDateTime time;
    //本身
    private String message;
    private List<GetMenuFromOrderByConsumerId> menuList;
//==

    public GetMenuFromOrderByConsumerId() {
    }

    public GetMenuFromOrderByConsumerId(int orderId, String name, int qty, LocalDateTime time) {
        this.orderId = orderId;
        this.name = name;
        this.qty = qty;
        this.time = time;
    }

    public GetMenuFromOrderByConsumerId(String message, List<GetMenuFromOrderByConsumerId> menuList) {
        this.message = message;
        this.menuList = menuList;
    }

    public GetMenuFromOrderByConsumerId(String message) {
        this.message = message;
    }
    //==

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<GetMenuFromOrderByConsumerId> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<GetMenuFromOrderByConsumerId> menuList) {
        this.menuList = menuList;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
