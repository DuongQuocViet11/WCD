package com.example.exampaper.model;

import com.example.exampaper.entity.Brand;

import java.util.List;

public interface BrandModel {
    Brand save(Brand obj);

    List<Brand> findAll();

}
