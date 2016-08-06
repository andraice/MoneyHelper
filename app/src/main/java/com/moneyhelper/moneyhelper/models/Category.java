package com.moneyhelper.moneyhelper.models;

import com.orm.SugarRecord;

import java.util.Date;
import java.util.List;

/**
 * Created by ORACLE on 02/07/2016.
 */
public class Category extends SugarRecord {

    private String name;

    public Category() {

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Category> getCategories(){
        List<Category> categories = Category.listAll(Category.class);
        return categories;
    }
}
