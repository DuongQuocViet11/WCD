package com.restaurant.restaurant.model;

import com.restaurant.restaurant.entity.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MySqlCategoryModelTest {

    private MySqlCategoryModel model;
    @BeforeEach
    void setUp() {
        model = new MySqlCategoryModel();
    }

    @Test
    public void save(){
        Category category = new Category();
        category.setName("Món nướng");
        model.save(category);
        Category category2 = new Category();
        category2.setName("Món luộc");
        model.save(category2);
        Category category3 = new Category();
        category3.setName("Món chay");
        model.save(category3);
        Category category4 = new Category();
        category4.setName("Đồ uống");
        model.save(category4);
    }

    @Test
    public void findbyId(){
        Category cate = model.findbyId(2);
        assertNotEquals(null, cate);
    }

    @Test
    public void delete(){
        model.delete(2);
    }
}