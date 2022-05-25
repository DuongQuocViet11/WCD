package com.example.loginandregister.model;

import com.example.loginandregister.entity.Account;
import com.example.loginandregister.entity.myenum.AccountStatus;
import com.example.loginandregister.util.MD5Hasher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MySqlAccountModelTest {

    private MySqlAccountModel model;
    @BeforeEach
    void setUp() {
        model = new MySqlAccountModel();
    }

    @Test
    void save() {
        Account account = new Account();
        String salt = MD5Hasher.randomString(15);
        account.setSalt(salt);
        account.setUsername("quocviet123");
        account.setPassword("quocviet321");
        account.setPasswordHash(MD5Hasher.encode(account.getPassword(), salt));
        account.setPhone("0582233082");
        account.setEmail("duongquocviet@gmail.com");
        account.setStatus(AccountStatus.ACTIVE);
        System.out.println(account.toString());
        model.save(account);
    }

    @Test
    void testLogin(){
        String username = "quocviet123";
        String password = "quocviet323";
        Account account = model.findByUsername(username);
        if (account == null){
            System.err.println("Thông tin không đúng");
        }else {
            String passwordHash = account.getPasswordHash();
            String salt = account.getSalt();
            String encodeString = MD5Hasher.encode(password, salt);
            System.out.println(encodeString);
            System.out.println(passwordHash);
            if (passwordHash.equals(encodeString)){
                System.out.println("Login success");
            }
        }
    }
}