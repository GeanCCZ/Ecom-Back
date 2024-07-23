package com.example.ecommerce.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.File;
import java.net.URL;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "image")
@Getter
@Setter
public class Image extends BaseEntity{

    @Column(name = "public_id", nullable = true)
    private String public_id;

    @Column(name = "source", nullable = true)
    private String source;

    @Column(name = "alt", nullable = true)
    private String alt;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "sequence", nullable = false, columnDefinition = "Integer default 0")
    private Integer sequence;

    @ToString.Exclude
    File image_file;

    @OneToOne
    private Brand brand;

    @ManyToOne
    private Product product;

    @OneToOne
    private RootGroup rootGroup;
}
