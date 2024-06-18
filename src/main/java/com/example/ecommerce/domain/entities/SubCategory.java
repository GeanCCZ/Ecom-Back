package com.example.ecommerce.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "subCategory")
@Getter
public class SubCategory extends BaseEntity{

    @Column(name = "display_name",nullable = false)
    private String displayName;

    @ManyToOne
    @JoinColumn
    private Category category;

    @ManyToMany
    private List<Product> productList;
}
