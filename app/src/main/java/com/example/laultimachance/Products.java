package com.example.laultimachance;

import java.util.HashMap;

public class Products {
    public String product;
    public String description;
    public String price;
    public HashMap<String, Boolean> category;

    public Products(){

    }

    public Products(String product, String description, String price) {
        this.product = product;
        this.description = description;
        this.price = price;
        this.category = new HashMap<>();
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public HashMap<String, Boolean> getCategory() {
        return category;
    }

    public void setCategory(HashMap<String, Boolean> category) {
        this.category = category;
    }
}
