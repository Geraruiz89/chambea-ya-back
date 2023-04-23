package com.example.helloworld.personas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Persona {
    private int id;
    private String nombre;
    private String apPat;
    private String apMaterno;
    private float sueldo;
    private boolean genero;
    
    /*

    si una clase NO tiene NINGÚN constructor, java le asigna 
    de manera automática un constructor que no recibe parámetros 
    y que además NO efectúa ninguna operación especial. O sea,
    lo equivalente (en esta clase, a lo siguiente:)

    Si la calse tiene AL MENOS 1 constructor creado por el programador,
    entonces java se olvida deque existe el constructor vacio mostrado 
    en el comentario anterior y sólo considera al (o a los) constructores
    creados por el programador.

    */
    
    public String toString() {
        return "adios";
    }
    
}
