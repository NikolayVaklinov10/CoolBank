package com.example.coolbank;

import com.example.coolbank.controllers.OfferController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class CoolBankApplicationTests {

    @Autowired
    private OfferController controller;

    @Test
    void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

}
