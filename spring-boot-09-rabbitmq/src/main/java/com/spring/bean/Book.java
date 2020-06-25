package com.spring.bean;

import lombok.Builder;
import lombok.Data;

@Data
public class Book {
    private String name;
    private String author;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public Book() {
    }
}
