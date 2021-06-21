package ex44;

import java.util.List;
/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Tommy Chang
 */


public class Products {
    private List<Product> products;

    public Products(List<Product> products){
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
