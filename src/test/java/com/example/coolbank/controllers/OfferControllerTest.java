package com.example.coolbank.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.coolbank.entities.Offers;
import com.example.coolbank.repositories.IOffersRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.BDDAssertions.then;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(OfferController.class)
@AutoConfigureMockMvc
public class OfferControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IOffersRepository offersRepository;

    private List<Offers> offers;

    @BeforeEach
    public void setUp() {
        offers = Arrays.asList(

                new Offers("Hanuka", 13, "Tel Aviv"),
                new Offers("St Patrick's Day", 31, "Boston"),
                new Offers("Easter", 23, "Orlando"),
                new Offers("Queen's Birthday", 95, "London"),
                new Offers("Chinese New Year", 35, "Shanghai"),
                new Offers("French Revolution Day", 24, "Paris")
        );
    }
    @Test
    public void createAnOffer() throws Exception {
        mockMvc.perform( MockMvcRequestBuilders
                .post("/offers")
                .content(asJsonString(new Offers("Xmas",2,"London")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

    }

    @Test
    public void checkAnOffer() throws Exception {
        // given
        Offers offerTest = new Offers("Hanuka",14,"Tel Aviv");
        // when
        Offers result = offersRepository.save(offerTest);
        // then
        then(result.equals(true));




    }



    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void wrongUrlOffer() throws Exception {
        mockMvc.perform( MockMvcRequestBuilders
                .post("/offer")
                .content(asJsonString(new Offers("St Patrick's Day",12,"Dublin")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

    }

    @Test
    public void getAllOffersInitially() throws Exception {
        mockMvc.perform( MockMvcRequestBuilders
                .get("/offers")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void getSingleOffer() throws Exception {
        mockMvc.perform( MockMvcRequestBuilders
                .get("/offers/{id}", 0)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
             //   .andExpect(MockMvcResultMatchers.jsonPath("$.offers").value(1));
    }

    @Test
    public void updateOffer() {
    }

    @Test
    public void deleteOffer() {
    }




}

