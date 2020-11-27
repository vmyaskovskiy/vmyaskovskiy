package ru.job4j.lsp;

import java.util.Date;

public class Food {
    private String name;
    private String expaireDate;
    private String createDate;
    private int price;
    private int disscount;

    public Food (String name, String expaireDate, String createDate, int price, int disscount) {
        this.name = name;
        this.expaireDate = expaireDate;
        this.createDate = createDate;
        this.price = price;
        this.disscount = disscount;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public int getPrice() {
        return this.price;
    }

    public void setDisscount(int disscount) {
        this.disscount = disscount;
    }
    public int getDisscount() {
        return this.disscount;
    }

    public String getExpaireDate() {
        return this.expaireDate;
    }

    public String getCreateDate() {
        return this.createDate;
    }

}
