package com.example.ecommerce.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Category extends BaseEntity{

    @Column(name = "display_name", nullable = false)
    private String displayName;

    @OneToMany
    private List<Product> productList;

}
