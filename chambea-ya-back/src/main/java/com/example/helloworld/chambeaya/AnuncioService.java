package com.example.helloworld.chambeaya;

import com.example.helloworld.chambeaya.model.Anuncio;
import com.example.helloworld.chambeaya.model.UsuarioAnuncio;

public interface AnuncioService {
    /**
     * Retorna todos los datos del anuncio de un usuario por su 
     * id especifico en especifico guardados en la base de datos.
     * @return Objeto de datos del anuncio del
     *  usuario provenientes de la base de datos.
     */
    Anuncio getDatosAnuncioIdUser(int id);
    
    /**
     * Retorna todos los datos del anuncio por su id de anuncio especifico
     * guardados en la base de datos.
     * @return Objeto de datos del anuncio
     *  provenientes de la base de datos.
     */
    Anuncio getDatosAnuncioId(int id);
    
    /**
     * Busca el id del anuncio dado y si no está en la base de datos, 
     * lo inserta, pero si está en la base, lo actualiza.
     * 
     * @param anuncio Anuncio a ser insertado o actualizado
     */
    void guarda(Anuncio anuncio);
    
    /**
     * Genera un array de objetos con los datos de usuario y su anuncio.
     * 
     * @return array de datos de usuario y anuncio para la vista de crear
     * anuncio y la card. 
     */
    UsuarioAnuncio getDatosAnuncioCompletos(int id);
    
}
