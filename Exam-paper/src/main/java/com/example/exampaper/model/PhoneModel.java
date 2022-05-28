package com.example.exampaper.model;

import com.example.exampaper.entity.Brand;
import com.example.exampaper.entity.Phone;

import java.util.List;

public interface PhoneModel {
    Phone save(Phone obj);

    List<Phone> findAll();

}
