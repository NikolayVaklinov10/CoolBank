package com.example.coolbank.controllers;


import com.example.coolbank.entities.Offers;
import com.example.coolbank.repositories.IOffersRepository;
import com.example.coolbank.services.OffersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
public class OfferController {

    @Autowired
    IOffersRepository offersRepository;
    @Autowired
    OffersService offersService;

    @PostMapping(path = "/offers")
    public ResponseEntity<Offers> save(@RequestBody Offers offer){
        try {
            return new ResponseEntity<>(offersRepository.save(offer), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/offers")
    public ResponseEntity<List<Offers>> getAllOffers() {
        try {
            List<Offers> list = offersRepository.findAll();
            if (list.isEmpty()) {
                return new ResponseEntity<List<Offers>>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<List<Offers>>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/offers/{id}")
    public ResponseEntity<Offers> getSingleOffer(@PathVariable Long id) {
        Optional<Offers> offer = offersRepository.findById(id);

        return offer.map(offers -> new ResponseEntity<>(offers, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PutMapping("/offers/{id}")
    public ResponseEntity<Offers> updateOffer(@RequestBody Offers offer) {
        try {
            return new ResponseEntity<>(offersRepository.save(offer), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/offers/{id}")
    public ResponseEntity<HttpStatus> deleteOffer(@PathVariable Long id) {
        try {
            Optional<Offers> offer = offersRepository.findById(id);
            if(offer.isPresent()) {
                offersRepository.delete(offer.get());
                offersService.removeOlderThan(offer.get().getCreatedAt());
            }
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




//    @DeleteMapping("/offers/{id}")
//    public ResponseEntity<HttpStatus> deleteExpiredOffer(@PathVariable Long id) {
//        try {
//            Optional<Offers> offer = offersService.findById(id);
//            offer.ifPresent(offers -> offersService.removeOlderThan(offers.getCreatedAt()));
//            offersRepository.delete(offer.get());
//            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }




}
