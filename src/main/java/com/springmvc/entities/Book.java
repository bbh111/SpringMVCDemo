package com.springmvc.entities;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class Book {

    private String title;

    private double price;

    private List<String> authors = new ArrayList<>();


    public Book() {
    }

    public Book(String title, double price, List<String> authors) {
        this.title = title;
        this.price = price;
        this.authors = authors;
    }

}