package com.example.helloworld.chambeaya;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.example.helloworld.chambeaya.model.Anuncio;

@Repository

public interface AnuncioMapper {
    @Results(
            id="AnuncioMap", 
            value = {
                @Result(property = "idUser",              column = "id_user"),
                @Result(property = "descripcionCorta",    column = "descripcion_corta"),
                @Result(property = "descripcionLarga",    column = "descripcion_larga"),
                @Result(property = "formaDeCobro",        column = "forma_de_cobro"),
                @Result(property = "nombreC",             column = "nombre_c"),
                @Result(property = "telefonoC",           column = "telefono_c"),
                @Result(property = "correoC",             column = "correo_c"),
                @Result(property = "anuncioActivo",       column = "anuncio_activo"),
                @Result(property = "anuncioRevisado",     column = "anuncio_revisado")
        })
    @Select("select * from anuncio_detalle where id_user=#{id}")
    Anuncio getDatosAnuncioIdUser(int id);
    
    @ResultMap("AnuncioMap")
    @Select("select * from anuncio_detalle where id=#{id}")
    Anuncio getDatosAnuncioId(int id);
    
    @Insert("INSERT INTO anuncio_detalle VALUES("
            + "#{id},"
            + " #{idUser},"
            + " #{descripcionCorta},"
            + " #{descripcionLarga},"
            + " #{ubicaciones},"
            + " #{disponibilidad},"
            + " #{formaDeCobro},"
            + " #{nombreC},"
            + " #{telefonoC},"
            + " #{correoC},"
            + " #{facebook},"
            + " #{instagram},"
            + " #{twitter},"
            + " #{youtube},"
            + " #{anuncioActivo},"
            + " #{anuncioRevisado})")
    void insert(Anuncio anuncio);
    
    @Update("update anuncio_detalle set "
            + "descripcion_corta=#{descripcionCorta},"
            + " descripcion_larga=#{descripcionLarga},"
            + " ubicaciones=#{ubicaciones},"
            + " disponibilidad=#{disponibilidad},"
            + " forma_de_cobro=#{formaDeCobro},"
            + " nombre_c=#{nombreC},"
            + " telefono_c=#{telefonoC},"
            + " correo_c=#{correoC},"
            + " facebook=#{facebook},"
            + " instagram=#{instagram},"
            + " twitter=#{twitter},"
            + " youtube=#{youtube},"
            + " anuncio_activo=#{anuncioActivo},"
            + " anuncio_revisado=#{anuncioRevisado}"
            + " where id=#{id}")
    void update(Anuncio anuncio);
}
