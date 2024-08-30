package com.example.ecommerce.domain.entities;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class LoginResponse {

    private String token;

    private Long expiresIn;

}
