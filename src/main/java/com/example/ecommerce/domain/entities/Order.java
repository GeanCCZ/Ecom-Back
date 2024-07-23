package com.example.ecommerce.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "\"order\"")
@Getter
@Setter
public class Order extends BaseEntity{

    @Column(name = "parcel", nullable = false, columnDefinition = "bool default false")
    private boolean parcel;

    @Column(name = "num_Parcels", nullable = false,columnDefinition = "Integer default 1")
    private Integer numParcels;

    @Column(name = "actual_Parcel", nullable = false,columnDefinition = "Integer default 1")
    private Integer actualParcel;

    @Column(name = "active",nullable = false, columnDefinition = "bool default true")
    private boolean active;

    @Column(name = "date",nullable = false)
    private Date date = new Date();

    @OneToMany
    @JoinColumn
    private List<OrderItem> orderItems;

    @ManyToOne
    @JoinColumn
    private User user;

}
