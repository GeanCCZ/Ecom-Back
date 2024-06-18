package com.example.ecommerce.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "supplier")
@Getter
public class Supplier extends BaseEntity{

    @Column(name = "trade_name",nullable = false)
    private String tradeName;

    @Column(name = "legal_name",nullable = false)
    private String legalName;

    @Column(name = "description",nullable = false)
    private String description;

    @Column(name = "cnpj",nullable = false)
    private String cnpj;

    @OneToMany
    @JoinColumn
    private List<Address> addressList;

    @OneToMany
    private List<Stock> stockList;

    @OneToMany
    private List<Product> productList;

}
