package com.example.loginandregister.entity;

import com.example.loginandregister.util.MD5Hasher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    @Test
    public void testSalt(){
        for (int i = 0; i < 100; i++) {
            System.out.println(MD5Hasher.randomString(5));
        }
    }

    @Test
    void testPasswordHash(){
        String salt = MD5Hasher.randomString(15);
        System.out.println(salt);
        String password = "iloveaptech";
        System.out.println(password);
        String encodeString = MD5Hasher.encode(password, salt);
        System.out.println(encodeString);
    }



}