package com.example.ecommerce.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stock")
@Getter
public class Stock extends BaseEntity{

    @Column(name = "quantity",nullable = false,columnDefinition = "Integer default 1")
    private Integer quantity;

    @OneToOne
    @JoinColumn
    private Supplier supplier;

    @OneToOne
    @JoinColumn
    private Product product;

}
