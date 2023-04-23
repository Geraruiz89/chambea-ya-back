package com.example.helloworld.chambeaya.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class JwtBody {
    private int userId;
    private String mail;
    private String role;
    private long creation;
}
