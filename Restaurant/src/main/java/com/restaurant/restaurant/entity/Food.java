package com.restaurant.restaurant.entity;

import com.restaurant.restaurant.entity.base.BaseEntity;
import com.restaurant.restaurant.entity.myenum.FoodStatus;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Food extends BaseEntity {
    private int id;
    private int categoryId;
    private String name;
    private String description;
    private String thumbnail;
    private double price;
    private FoodStatus status;


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

    private void checkValidate() {
        if (name == null || name.length() == 0) {
            errors.put("name", "Please enter name");
        }else {
            if (name.length() < 7){
                errors.put("name", "Name must have more than 7 characters");
            }
        }
        if (price == 0) {
            errors.put("price", "Please enter price");
        }
        if (description == null || description.length() == 0) {
            errors.put("description", "Please enter description");
        }
        if (thumbnail == null || thumbnail.length() == 0){
            errors.put("thumbnail", "Please choose image");
        }
    }

    public Food() {
        this.name = "";
        this.description = "";
        this.price = 0;
        this.thumbnail = "";
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
        this.status = FoodStatus.DANGBAN;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", errors=" + errors +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public FoodStatus getStatus() {
        return status;
    }

    public void setStatus(FoodStatus status) {
        this.status = status;
    }
}
