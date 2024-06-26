package com.example.ecommerce.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
@Getter
public class Category extends BaseEntity{

    @Column(name = "display_name", nullable = false)
    private String displayName;

    @OneToMany
    private List<SubCategory> subCategoryList;
}
