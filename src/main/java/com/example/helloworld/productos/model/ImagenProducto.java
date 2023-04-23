package com.example.helloworld.productos.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ImagenProducto {
    private int id;
    private int idProducto;
    private String nombre;
    private boolean actuva;
}
