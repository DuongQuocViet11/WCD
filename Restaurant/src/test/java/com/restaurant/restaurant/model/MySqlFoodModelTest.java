package com.restaurant.restaurant.model;

import com.restaurant.restaurant.entity.Food;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MySqlFoodModelTest {

    private FoodModel model;
    @BeforeEach
    void setUp() {
        model = new MySqlFoodModel();
    }

    @Test
    public void create(){
        Food product = new Food();
        product.setCategoryId(1);
        product.setName("Dồi sụn nướng");
        product.setPrice(100);
        product.setDescription("Lorem ipsum");
        product.setThumbnail("Lorem ipsum");
        model.save(product);
    }

    @Test
    public void findAll(){
        System.out.println(model.findAll().size());
    }

    @Test
    public void findById(){
        System.out.println(model.findbyId(1).toString());
    }
}