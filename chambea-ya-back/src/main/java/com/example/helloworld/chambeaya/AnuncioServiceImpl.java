package com.example.helloworld.chambeaya;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.helloworld.chambeaya.model.Anuncio;
import com.example.helloworld.chambeaya.model.UsuarioAnuncio;
import com.example.helloworld.chambeaya.model.UsuarioCorto;

@Primary
@Service

public class AnuncioServiceImpl implements AnuncioService{
    private AnuncioMapper anuncioMapper;
    private ChambeaMapper chambeaMapper;

    public AnuncioServiceImpl(AnuncioMapper anuncioMapper, ChambeaMapper chambeaMapper) {
        this.anuncioMapper = anuncioMapper;
        this.chambeaMapper = chambeaMapper;
    }

    public Anuncio getDatosAnuncioIdUser(int id) {
        return anuncioMapper.getDatosAnuncioIdUser(id);
    }

    public Anuncio getDatosAnuncioId(int id) {
        return anuncioMapper.getDatosAnuncioId(id);
    }
    
    public void guarda(Anuncio anuncio) {
        int id = anuncio.getId();
        Anuncio encontrado = this.getDatosAnuncioId(id);
        // si NO hay ningún renglón en la tabla "Persona",cuyo id sea
        // el parámetro que recibe el método 'ObtenProductoPorId'
        // entonces la variable "encontrado" será ingual a: null
        if(encontrado==null) {
            anuncioMapper.insert(anuncio);
        } else {
            anuncioMapper.update(anuncio);
        }
    }

    public UsuarioAnuncio getDatosAnuncioCompletos(int id) {
        UsuarioCorto usuario = chambeaMapper.getDatosCortos(id);
        Anuncio anuncio = anuncioMapper.getDatosAnuncioIdUser(id);
        return new UsuarioAnuncio(usuario, anuncio);
    }

    public void updateImagenPrincipal(String enc, int id) {
        anuncioMapper.updateImagenPrincipal(enc, id);
        
    }
}
