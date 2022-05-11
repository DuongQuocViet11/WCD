package com.t2010a.t2010a.model;

import com.t2010a.t2010a.entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryCustomerModelTest {
    InMemoryCustomerModel model;

    @BeforeEach
    void setUp() {
        model = new InMemoryCustomerModel();
    }

    @Test
    void save() {
        System.out.println(model.findAll().size());
        Customer customer = new Customer(
                "C05",
                "Tien Thanh",
                "0582233081",
                "",
                LocalDateTime.of(1999,2, 1, 11, 11)
        );
        model.save(customer);
        System.out.println(model.findAll().size());
    }

    @Test
    void findAll() {
        System.out.println(model.findAll().size());
    }

    @Test
    void findById() {
        Customer customer = model.findById("C03");
        System.out.println(customer.toString());
    }

    @Test
    void update() {
        Customer customer = model.findById("C01");
        customer.setName("Duong Quoc Viet");
        model.update("C01", customer);
        for (Customer cus: model.findAll()){
            System.out.println(cus.toString());
        }
    }

    @Test
    void delete() {
        model.delete("C04");
        for (Customer cus: model.findAll()){
            System.out.println(cus.toString());
        }
    }
}