package com.example.exampaper.entity;

import com.example.exampaper.entity.base.BaseEntity;

import java.time.LocalDateTime;

public class Brand extends BaseEntity {
    private int id;
    private String name;

    public Brand(int id, String name) {
        this.id = id;
        this.name = name;
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
    }

    public Brand() {
        this.setUpdatedAt(LocalDateTime.now());
        this.setCreatedAt(LocalDateTime.now());
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
}
