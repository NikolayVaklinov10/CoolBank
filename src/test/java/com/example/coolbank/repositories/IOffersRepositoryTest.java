package com.example.coolbank.repositories;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

@RunWith(SpringRunner.class)
@DataJpaTest
class IOffersRepositoryTest {

    @Autowired
    private IOffersRepository repository;


    @Test
    public void deletingOfferAfterOneDayTest() throws Exception {

        Date result = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2017-12-15 10:00");
        Date offer = (result);
        Date result2 = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2017-12-16 10:00");

        assertThat(offer,lessThanOrEqualTo(result2));


    }

}