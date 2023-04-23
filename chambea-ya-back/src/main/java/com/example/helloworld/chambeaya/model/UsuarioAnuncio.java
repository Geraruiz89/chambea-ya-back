package com.example.helloworld.chambeaya.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UsuarioAnuncio {
    private UsuarioCorto usuarioCorto;
    private Anuncio anuncio;
}
