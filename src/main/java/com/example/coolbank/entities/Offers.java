package com.example.coolbank.entities;


import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Data
@Entity
@RequiredArgsConstructor
@Table(name = "tbl_offer")
public class Offers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String offer_name;

    private Integer age;

    private String location;

    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;


    public Offers(String offer_name, Integer age, String location) {
        this.offer_name = offer_name;
        this.age = age;
        this.location = location;

    }
}
