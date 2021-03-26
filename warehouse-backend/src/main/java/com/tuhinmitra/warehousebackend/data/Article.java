package com.tuhinmitra.warehousebackend.data;

import org.springframework.data.annotation.Id;

public class Article {

    @Id
    private String artId;
    private String name;
    private int stock;

    public Article(String artId, String name, int stock){
        this.artId = artId;
        this.name = name;
        this.stock = stock;
    }

    public String getId() {
        return artId;
    }

    public String getName() {
        return name;
    }

    public int getAvailableStock() {
        return stock;
    }

    public void setAvailableStock(int stock) {
        this.stock = stock;
    }
}
