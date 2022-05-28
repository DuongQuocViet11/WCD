package com.example.exampaper.model;

import com.example.exampaper.entity.Brand;
import com.example.exampaper.entity.Phone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MySqlBrandModelTest {

    private MySqlBrandModel model;
    @BeforeEach
    void setUp() {
        model = new MySqlBrandModel();
    }

    @Test
    void save(){
        Brand brand1 = new Brand();
        brand1.setName("Samsung");
        model.save(brand1);
        Brand brand2 = new Brand();
        brand2.setName("Nokia");
        model.save(brand2);
        Brand brand3 = new Brand();
        brand3.setName("Other");
        model.save(brand3);
    }

    @Test
    void findAll(){
        System.out.println(model.findAll().size());
    }
}