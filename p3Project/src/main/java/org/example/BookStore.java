package org.example;

import java.util.ArrayList;

public class BookStore {
    private String city;
    private String name;

    public BookStore(String city, String name) {
        this.city = city;
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }
}
