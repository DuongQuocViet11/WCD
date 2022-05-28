package com.example.exampaper.model;

import com.example.exampaper.entity.Phone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MySqlPhoneModelTest {


    private MySqlPhoneModel model;
    @BeforeEach
    void setUp() {
        model = new MySqlPhoneModel();
    }

    @Test
    void save(){
            Phone phone = new Phone();
            phone.setBrandId(3);
            phone.setName("Nokia 1110");
            phone.setPrice(100);
            phone.setDescription("Đây là nokia");
            model.save(phone);
    }
}