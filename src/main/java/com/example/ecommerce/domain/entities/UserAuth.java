package com.example.ecommerce.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserAuth {

    private String email;
    @ToString.Exclude
    private String password;

}
