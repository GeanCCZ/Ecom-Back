package com.example.ecommerce.domain.entities;

import jakarta.annotation.Nullable;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
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

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"user\"")
@Getter
@Setter
@Builder
public class User extends BaseEntity {

    @OneToMany
    @JoinColumn(nullable = true)
    private List<Address> addresses;

    @OneToOne
    @JoinColumn
    private Role role;

    @OneToOne
    @JoinColumn
    private Image image;

    @OneToMany
    @JoinColumn
    private List<Order> orders;

    @OneToMany
    private List<Review> reviewList;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email",unique = true)
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "password")
    private String password;

    @Nullable
    boolean enabled;

    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;

}
