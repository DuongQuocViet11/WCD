package com.example.exampaper.entity;

import com.example.exampaper.entity.base.BaseEntity;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Phone extends BaseEntity {
    private int id;
    private int brandId;
    private String name;

    private double price;
    private String description;


    private HashMap<String, String> errors = new HashMap<>();

    public HashMap<String, String> getErrors() {
        return errors;
    }

    public void setErrors(HashMap<String, String> errors) {
        this.errors = errors;
    }

    public boolean isValid(){
        checkValidate();
        return errors.size() == 0;
    }

    public Phone(int id, int brandId, String name, double price, String description) {
        this.id = id;
        this.brandId = brandId;
        this.name = name;
        this.price = price;
        this.description = description;

    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brandId=" + brandId +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", errors=" + errors +
                '}';
    }

    private void checkValidate() {
        if (name == null || name.length() == 0) {
            errors.put("name", "Please enter name");
        }
        if (price == 0) {
            errors.put("price", "Please enter price");
        }
        if (description == null || description.length() == 0) {
            errors.put("description", "Please enter description");
        }
    }

    public Phone() {
        this.name = "";
        this.description = "";
        this.price = 0;
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
