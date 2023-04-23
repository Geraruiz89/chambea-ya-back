package com.example.helloworld.productos.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CaracteristicaProducto {
    private int id;
    private int idProducto;
    private String descripcion;
    private boolean actuva;
}
