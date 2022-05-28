package com.restaurant.restaurant.model;

import com.restaurant.restaurant.entity.Category;
import com.restaurant.restaurant.entity.Food;

import java.util.List;

public interface FoodModel {
    Food save(Food food);

    List<Food> findAll();

    Food findbyId(int id);

    Food update(int id, Food updateFood);

    boolean delete(int id);
}
