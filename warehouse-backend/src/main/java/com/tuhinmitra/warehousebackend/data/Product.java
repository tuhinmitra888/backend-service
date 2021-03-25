package com.tuhinmitra.warehousebackend.data;

import java.util.HashMap;
import java.util.List;

public class Product {

    private String name;
    private float price;
    List<HashMap> buildingBlocksArticles;

    public Product(String name, float price, List<HashMap> buildingBlocksArticles) {
        this.name = name;
        this.price = price;
        this.buildingBlocksArticles = buildingBlocksArticles;
    }


    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public List<HashMap> getBuildingBlocksArticles() {
        return buildingBlocksArticles;
    }


}
