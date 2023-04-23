package com.example.helloworld.chambeaya.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PagoDetalle {
    private int id;
    private int idUser;
    private String nombre;
    private String numTarjeta;
    private String vencimiento;
    private int ccv;
}
