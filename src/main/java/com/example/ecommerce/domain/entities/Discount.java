package com.example.ecommerce.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "discount")
@Getter
@Setter
public class Discount extends BaseEntity{

    @Column(name = "presented_value")
    private Double presentedValue;

    @Column(name = "type")
    private Number type;

    @Column(name = "final_value")
    private Double finalValue;

    @OneToMany
    private List<Product> productList;

}
