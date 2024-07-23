package com.example.ecommerce.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
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
@Table(name = "rootGroup")
@Getter
@Setter
public class RootGroup  extends BaseEntity{

    @Column(name = "display_name",nullable = false)
    private String displayName;

    @Column(name = "sequence", nullable = false, columnDefinition = "Integer default 0")
    private Integer sequence;

    @OneToOne
    @JoinColumn
    private Image image;

    @OneToMany
    @JoinColumn
    private List<Product> productList;

    @OneToOne
    private Category category;
}
