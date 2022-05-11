package com.t2010a.t2010a.model;

import com.t2010a.t2010a.entity.Customer;

import java.util.List;

public interface CustomerModel {
    Customer save(Customer customer); //lưu thông tin

    List<Customer> findAll();

    Customer findById(String cusId);

    Customer update (String cusId, Customer updateCustomer);

    boolean delete (String cusId);
}
