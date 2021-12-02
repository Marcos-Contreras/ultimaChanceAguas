package com.example.laultimachance;

import java.util.HashMap;

public class Cart {
    public String product;
    public String description;
    public String price;
    public String image;

    public Cart() {
    }

    public Cart(String product, String description, String price, String image) {
        this.product = product;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public String getProduct() {
        return product;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
