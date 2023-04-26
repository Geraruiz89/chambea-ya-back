package com.example.helloworld.chambeaya;

import java.util.List;

import com.example.helloworld.chambeaya.model.Estados;
import com.example.helloworld.chambeaya.model.Oficios;
import com.example.helloworld.chambeaya.model.PagoDetalle;
import com.example.helloworld.chambeaya.model.Usuario;
import com.example.helloworld.chambeaya.model.UsuarioCorto;
import com.example.helloworld.chambeaya.model.UsuarioDatosP;

public interface ChambeaService {
    /**
     * Retorna todos los datos de un usuario en especifico
     * guardados en la base de datos.
     * @return Objeto de datos de usuario provenientes de la base de datos.
     */
    Usuario getDatos(int id);
    
    /**
     * Busca el id del usuario dado y si no está en la base de datos, 
     * lo inserta, pero si está en la base, lo actualiza.
     * 
     * @param usuario Usuario a ser insertado o actualizado
     */
    void guarda(Usuario usuario);
    
    /**
     * Busca el id del usuario dado y guarda su informacion en la base de 
     * datos solo aquellos datos que el puede modificar y no los datos que
     * se modifican por un administrado como likes, habilidato etc.
     * 
     * @param usuario Usuario a ser actualizado
     */
    void guardaDatosPersonales(UsuarioDatosP usuarioDatosP);
    
    /**
     * Retorna solo los datos de un usuario necesarios para pintar una card
     * de su anuncio o el detalle de su anuncio
     * @return Objeto de datos de usuario cortos provenientes 
     * de la base de datos.
     */
    UsuarioCorto getDatosCortos(int id);
    
    /**
     * Retorna todos los oficios que esta activos en la base de datos y con su
     * id y nombre
     * @return Objeto de array de oficios provenientes 
     * de la base de datos.
     */
    List<Oficios> getDatosOficios();
    
    /**
     * Retorna los datos de pago del usuario por su id
     * de su anuncio o el detalle de su anuncio
     * @return Objeto de datos de usuario cortos provenientes 
     * de la base de datos.
     */
    PagoDetalle getDatosPagoDetalle(int id);
    
    /**
     * Inserta o acualiza los datos bancarios de un usuario por su idUser
     * 
     * @param PagoDetalle pagodetalle a ser insertado o actualizado
     */
    void guardaDatosBancarios(PagoDetalle pagoDetalle);
    
    /**
     * Retorna todos los estados de la republica en la base de datos y con su
     * id y nombre
     * @return Objeto de array de estados provenientes 
     * de la base de datos.
     */
    List<Estados> getDatosEstados();

}
