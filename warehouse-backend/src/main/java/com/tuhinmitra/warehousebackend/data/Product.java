package com.tuhinmitra.warehousebackend.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.data.annotation.Id;

import java.util.List;

public class Product {

    @Id
    private String name;
    private float price;
    List<ContainArticles> containArticles;

    @JsonCreator
    public Product(String name, float price, List<ContainArticles> containArticles) {
        this.name = name;
        this.price = price;
        this.containArticles = containArticles;
    }
    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public static class ContainArticles {
        private final String artId;
        private final int amountOf;

        @JsonCreator
        public ContainArticles(String artId, int amountOf) {
            this.artId = artId;
            this.amountOf = amountOf;
        }

        public String getArtId() {
            return artId;
        }

        public int getAmountOf() {
            return amountOf;
        }
    }


    public List<ContainArticles> getContainArticles() {
        return containArticles;
    }


}
