package com.example.coolbank.services;

import com.example.coolbank.repositories.IOffersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class OffersService {

    private final IOffersRepository iOffersRepository;

    @Autowired
    public OffersService(IOffersRepository iOffersRepository) {
        this.iOffersRepository = iOffersRepository;
    }

//    public Date removeOlderThan() {
//        Calendar cal = Calendar.getInstance();
//        cal.add(Calendar.DATE, -1);
//        Date oneDay = new Date(cal.getTimeInMillis());
//          return   iOffersRepository.removeOlderThan(oneDay);
//
//    }


}
