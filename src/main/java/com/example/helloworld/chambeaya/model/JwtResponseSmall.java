package com.example.helloworld.chambeaya.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponseSmall {
    private boolean isJwtValid;
    private String body;
}
