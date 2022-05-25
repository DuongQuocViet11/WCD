package com.example.loginandregister.model;

import com.example.loginandregister.entity.Account;

import java.util.List;

public interface AcountModel {
    Account save(Account obj);

    List<Account> findAll();

    Account findById(int id);

    Account findByUsername(String username);

    Account findByEmail(String email);

    Account update(int id, Account updateObj);

    boolean delete(int id);
}
