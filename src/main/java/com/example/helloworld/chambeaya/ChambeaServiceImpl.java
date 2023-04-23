package com.example.helloworld.chambeaya;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.helloworld.chambeaya.model.Oficios;
import com.example.helloworld.chambeaya.model.PagoDetalle;
import com.example.helloworld.chambeaya.model.Usuario;
import com.example.helloworld.chambeaya.model.UsuarioCorto;
import com.example.helloworld.chambeaya.model.UsuarioDatosP;

@Primary
@Service

public class ChambeaServiceImpl implements ChambeaService {
    private ChambeaMapper chambeaMapper;
    
    public ChambeaServiceImpl( ChambeaMapper chambeaMapper ) {
        this.chambeaMapper = chambeaMapper;
    }
    
    public Usuario getDatos(int id) {
        return chambeaMapper.getDatos(id);
    }
    
    public UsuarioCorto getDatosCortos(int id) {
        return chambeaMapper.getDatosCortos(id);
    }
    
    public void guarda(Usuario usuario) {
        int id = usuario.getIdUser();
        Usuario encontrado = this.getDatos(id);
        // si NO hay ningún renglón en la tabla "Persona",cuyo id sea
        // el parámetro que recibe el método 'ObtenProductoPorId'
        // entonces la variable "encontrado" será ingual a: null
        if(encontrado==null) {
            chambeaMapper.insert(usuario);
        } else {
            chambeaMapper.update(usuario);
        }
    }

    public void guardaDatosPersonales(UsuarioDatosP usuarioDatosP) {
        chambeaMapper.updateDatosPersonales(usuarioDatosP);
        
    }

    public List<Oficios> getDatosOficios() {
        return chambeaMapper.getOficiosActivos();
    }

    public PagoDetalle getDatosPagoDetalle(int id) {
        return chambeaMapper.getDatosDePago(id);
    }

    public void guardaDatosBancarios(PagoDetalle pagoDetalle) {
        int id = pagoDetalle.getIdUser();
        PagoDetalle encontrado = this.getDatosPagoDetalle(id);
        if(encontrado==null) {
            chambeaMapper.insertDatosBancarios(pagoDetalle);
            
        } else {
            chambeaMapper.updateDatosBancarios(pagoDetalle);
            
        }
    }
}
