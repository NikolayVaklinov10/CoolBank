package com.example.coolbank.configurations;

import com.example.coolbank.entities.Offers;
import com.example.coolbank.repositories.IOffersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OfferConfig {

    @Bean
    CommandLineRunner commandLineRunner(IOffersRepository repository){
        return args -> {
            Offers christmas = new Offers("XMas", 21, "New York");
             Offers newYear = new Offers("New Year's Eve", 19, "Sidney");

            repository.saveAll(List.of(christmas, newYear));
        };


    }
}
