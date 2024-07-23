package com.example.ecommerce.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "review")
@Getter
@Setter
public class Review extends BaseEntity{

    @Column(name = "avaliation_value",nullable = false)
    private Integer avaliationValue;

    @Column(name = "comment",nullable = true)
    private String comment;

    @Column(name = "date",nullable = false)
    private Date date = new Date();

    @ManyToOne
    private Product product;

    @ManyToOne
    @JoinColumn
    private User user;

}
