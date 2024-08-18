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
@Table(name = "role")
@Getter
@Setter
public class Role extends BaseEntity{

    @Column(name = "display_name",nullable = false)
    private String displayName;

    @OneToMany
    private List<User> userList;
}
