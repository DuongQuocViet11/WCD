package com.t2010a.t2010a.model;

import com.t2010a.t2010a.entity.Customer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class InMemoryCustomerModel implements CustomerModel{
    private static List<Customer> customers;
    public InMemoryCustomerModel(){
        customers = new ArrayList<>();
        customers.add(
                new Customer(
                        "C01",
                        "Quoc Viet",
                        "0941077550",
                        "",
                        LocalDateTime.of(2000,11,11,11,11),
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        1
                )
        );
        customers.add(
                new Customer(
                        "C02",
                        "Viet Duong",
                        "0582233082",
                        "",
                        LocalDateTime.of(2004,10,2,2,3),
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        1
                )
        );
        customers.add(
                new Customer(
                        "C03",
                        "Quoc Duong",
                        "034567891",
                        "",
                        LocalDateTime.of(2003,2,11,11,11),
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        1
                )
        );
        customers.add(
                new Customer(
                        "C04",
                        "Duong Viet",
                        "078515623",
                        "",
                        LocalDateTime.of(2007,3,1,10,11),
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        1
                )
        );
    }

    @Override
    public Customer save(Customer customer) {
        customers.add(customer);
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public Customer findById(String cusId) {
        Customer foundCustomer = null;
        for(Customer customer:
                    customers){
            if (customer.getCusID().equals(cusId)){
                foundCustomer = customer;
                break;
            }
        }
        return foundCustomer;
    }

    @Override
    public Customer update(String cusId, Customer updateCustomer) {
        Customer existingCustomer = findById(cusId);
        if (existingCustomer == null){
            return null;
        }
        existingCustomer.setName(updateCustomer.getName());
        existingCustomer.setPhone(updateCustomer.getPhone());
        existingCustomer.setImage(updateCustomer.getImage());
        existingCustomer.setDob(updateCustomer.getDob());
        existingCustomer.setUpdatedAt(LocalDateTime.now());
        existingCustomer.setStatus(updateCustomer.getStatus());
        return existingCustomer;
    }

    @Override
    public boolean delete(String cusId) {
        int foundIndex = -1;
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getCusID().equals(cusId)){
                foundIndex = i;
            }
        }
        if (foundIndex != -1){
            customers.remove(foundIndex);
            return true;
        }
        return false;
    }
}
