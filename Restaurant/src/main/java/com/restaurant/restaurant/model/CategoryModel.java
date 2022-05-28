package com.restaurant.restaurant.model;

import com.restaurant.restaurant.entity.Category;

import java.util.List;

public interface CategoryModel {
    Category save(Category cate);

    List<Category> findAll();

    Category findbyId(int id);

    Category update(int id, Category updateCate);

    boolean delete(int id);
}
