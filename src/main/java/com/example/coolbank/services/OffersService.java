package com.example.coolbank.services;

import com.example.coolbank.entities.Offers;
import com.example.coolbank.repositories.IOffersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Service
public class OffersService {

    private final IOffersRepository iOffersRepository;

    @Autowired
    public OffersService(IOffersRepository iOffersRepository) {
        this.iOffersRepository = iOffersRepository;
    }


    public Optional<Offers> findById(Long id) {

        return iOffersRepository.findById(id);
    }

    public void removeOlderOffer() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        Date oneDay = new Date(cal.getTimeInMillis());
        iOffersRepository.removeOlderThan(oneDay);
    }



}
