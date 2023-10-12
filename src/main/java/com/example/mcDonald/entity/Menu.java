package com.example.mcDonald.entity;

import javax.persistence.*;

@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "category")
    private String category;
    @Column(name = "inventory")
    private int inventory;
    @Column(name = "price")
    private int price;
    @Column(name = "serve_time")
    private int serveTime;
    @Column(name = "description")
    private String description;
    @Column(name = "img")
    private String img;
    @Column(name = "sales")
    private int sales;
    @Column(name = "status")
    private int status;
//==


    public Menu() {
    }



    public Menu(String name, int price, int serveTime, String description, String img) {

        this.name = name;
        this.price = price;
        this.serveTime = serveTime;
        this.description = description;
        this.img = img;
    }
    //==

    public String getCategory() {
        return category;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }
}
