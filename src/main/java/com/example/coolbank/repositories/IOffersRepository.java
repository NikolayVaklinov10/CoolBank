package com.example.coolbank.repositories;

import com.example.coolbank.entities.Offers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
public interface IOffersRepository extends JpaRepository<Offers, Long> {


//    @Modifying
//    @Transactional
//    @Query(value = "DELETE FROM Offers o WHERE o.createdAt < :date")
//    Date removeOlderThan(@Param("date") Date date);
}


