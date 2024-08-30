package com.example.ecommerce.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.boot.context.properties.bind.DefaultValue;

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

    @Column(name = "enabled")
    private boolean enabled = true;

    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;
}
