package com.example.ecommerce.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
@Getter
@Setter
public class Product extends BaseEntity{

    @Column(name = "display_name",nullable = false)
    private String displayName;

    @Column(name = "description",nullable = true)
    private String description;

    @Column(name = "price",nullable = false,columnDefinition = "Decimal(10,2) default 0.0")
    private Double price;

    @Column(name = "applicable_discount",nullable = true,columnDefinition = "Decimal(10,2) default 0.0")
    private Boolean discountEnabled;

    @OneToMany
    @JoinColumn
    private List<Stock> stockList;

    @ManyToOne
    @JoinColumn
    private Discount discount;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn
    private List<Image> imageList;

    @OneToOne
    @JoinColumn
    private Category category;

    @OneToMany
    @JoinColumn(name="sub_category")
    private List<SubCategory> subCategoryList;

    @OneToOne
    @JoinColumn
    private Brand brand;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn
    private List<Review> reviewList;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn
    public Supplier supplier;
}
