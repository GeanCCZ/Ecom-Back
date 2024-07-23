package com.example.ecommerce.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
@Getter
@Setter
public class Category extends BaseEntity{

    @Column(name = "display_name", nullable = false)
    private String displayName;

    @OneToMany
    private List<Product> productList;

}
