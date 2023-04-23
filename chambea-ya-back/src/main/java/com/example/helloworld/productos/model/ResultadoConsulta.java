package com.example.helloworld.productos.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultadoConsulta {
    private Producto producto;
    private List<String> caracteristicas;
    private List<String> imagenes;
}
