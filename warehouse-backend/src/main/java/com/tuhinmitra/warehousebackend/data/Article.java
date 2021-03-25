package com.tuhinmitra.warehousebackend.data;

public class Article {

    private String id;
    private String name;
    private long availableStock;

    public Article(String id, String name, long availableStock){
        this.id = id;
        this.name = name;
        this.availableStock = availableStock;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getAvailableStock() {
        return availableStock;
    }
}
