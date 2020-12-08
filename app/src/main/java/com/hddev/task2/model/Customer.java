package com.hddev.task2.model;



import java.util.List;

public class Customer {
    private String name;
    private String Category;

    private List<Item> mItems;

    public Customer() {
    }


    public String getName() {
        return name;
    }

    public List<Item> getmItems() {
        return mItems;
    }

    public void setmItems(List<Item> mItems) {
        this.mItems = mItems;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

}
