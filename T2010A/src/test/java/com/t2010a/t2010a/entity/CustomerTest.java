package com.t2010a.t2010a.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    @Test
    public  void  testCreateCustomer(){
        Customer customer = new Customer();
        customer.setCusID("C01");
        customer.setName("Quoc Viet");
        customer.setPhone("0941077550");
        customer.setImage("");
        customer.setDob(LocalDateTime.of(2000,11,11, 11, 11));
        customer.setCreatedAt(LocalDateTime.now());
        customer.setUpdatedAt(LocalDateTime.now());
        customer.setStatus(1);
        System.out.println(customer.toString());
    }

}