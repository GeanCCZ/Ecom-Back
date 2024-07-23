package com.example.ecommerce.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "OrderItem")
@Getter
@Setter
public class OrderItem extends BaseEntity{

    @OneToOne
    @JoinColumn
    private Product product;

    @ManyToOne
    private Order order;

    @Column(name = "quantity",nullable = false,columnDefinition = "Integer default 1")
    private int quantity;

    @Column(name = "total_Price",nullable = false,columnDefinition = "Decimal(10,2) default 0.0")
    private Double totalPrice;
}
