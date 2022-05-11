package com.t2010a.t2010a.model;

import com.t2010a.t2010a.entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MySqlCustomerModelTest {
    CustomerModel model;

    @BeforeEach
    void setUp() {
        model = new MySqlCustomerModel();
    }

    @Test
    void save() {
        model.save(new Customer("C02", "Thanh", "0582233081", "", LocalDateTime.of(1999,2,1,12,1)));
    }

    @Test
    void findAll() {
        List<Customer> list = model.findAll();
        for (Customer cus:
                list){
            System.out.println(cus.toString());
        }
    }

    @Test
    void findById() {
        Customer customer = model.findById("C06");
        assertEquals("Cuong", customer.getName());
    }

    @Test
    void update() {
        Customer customer = model.findById("C06");
        customer.setName("Quoc Viet Duong");
        model.update("C06", customer);
        Customer newUpdateCustomer = model.findById("C06");
        assertEquals("Quoc Viet Duong", newUpdateCustomer.getName());
    }

    @Test
    void delete() {
        model.delete("C06");
        Customer customer = model.findById("C06");
        assertEquals(null, customer);
    }
}