package com.example.helloworld.productos.model;

import lombok.*;

@Data
@NoArgsConstructor
public class Producto {
    private int id;
    private String nombre;
    private double totalStars;
    private int votosTotales;
    private int vendidas;
    private double precio;
    private int mensualidad;
    private int minutos;
    private String direccion;
    private int numVentas;
    private int totalProd;
    private int unidades;
    private String tienda;
    private int totalVentas;
    private int meses;
    private String especDia;
    private String descripcion;
    private boolean activa;
    private String nombreImagenPrincipal;
}
