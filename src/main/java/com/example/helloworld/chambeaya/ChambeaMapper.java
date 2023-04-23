package com.example.helloworld.chambeaya;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.example.helloworld.chambeaya.model.Oficios;
import com.example.helloworld.chambeaya.model.PagoDetalle;
import com.example.helloworld.chambeaya.model.Usuario;
import com.example.helloworld.chambeaya.model.UsuarioCorto;
import com.example.helloworld.chambeaya.model.UsuarioDatosP;

@Repository

public interface ChambeaMapper {
    @Results(
            id="UsuariosMap", 
            value = {
                @Result(property = "idUser",        column = "id_user"),
                @Result(property = "apellidoP",     column = "apellido_p"),
                @Result(property = "apellidoM",     column = "apellido_m"),
                @Result(property = "fechaN",        column = "fecha_n"),
                @Result(property = "codigoPostal",  column = "codigo_postal"),
                @Result(property = "telefonoP",     column = "telefono_p"),
                @Result(property = "correoP",       column = "correo_p"),
                @Result(property = "imagenD",       column = "imagen_d"),
                @Result(property = "metodoPago",    column = "metodo_pago")
        })

    @Select("select * from usuario_detalle where id_user=#{id}")
    Usuario getDatos(int id);
    
    @Results(
            id="UsuariosMapCorto", 
            value = {
                @Result(property = "idUser",        column = "id_user")
        })
    @Select("select id_user, nick, likes, oficio, habilitado from usuario_detalle where id_user=#{id}")
    UsuarioCorto getDatosCortos(int id);
    
    @Insert("INSERT INTO usuario_detalle VALUES("
            + "#{idUser},"
            + " #{nombre},"
            + " #{apellidoP},"
            + " #{apellidoM},"
            + " #{nick},"
            + " #{likes},"
            + " #{fechaN},"
            + " #{codigoPostal},"
            + " #{oficio},"
            + " #{telefonoP},"
            + " #{correoP},"
            + " #{habilitado},"
            + " #{imagenD},"
            + " #{metodoPago})")
    void insert(Usuario usuario);
    
    @Update("update usuario_detalle set "
            + "nombre=#{nombre},"
            + " apellido_p=#{apellidoP},"
            + " apellido_m=#{apellidoM},"
            + " nick=#{nick},"
            + " likes=#{likes},"
            + " fecha_n=#{fechaN},"
            + " codigo_postal=#{codigoPostal},"
            + " oficio=#{oficio},"
            + " telefono_p=#{telefonoP},"
            + " correo_p=#{correoP},"
            + " habilitado=#{habilitado},"
            + " imagen_d=#{imagenD},"
            + " metodo_pago=#{metodoPago}"
            + " where id_user=#{idUser}")
    void update(Usuario usuario);

    @Update("update usuario_detalle set "
            + "nombre=#{nombre},"
            + " apellido_p=#{apellidoP},"
            + " apellido_m=#{apellidoM},"
            + " fecha_n=#{fechaN},"
            + " codigo_postal=#{codigoPostal},"
            + " oficio=#{oficio},"
            + " telefono_p=#{telefonoP},"
            + " correo_p=#{correoP}"
            + " where id_user=#{idUser}")
    void updateDatosPersonales(UsuarioDatosP usuarioDatosP);

    @Select("select id, nombre from oficio where activo=true")
    List<Oficios> getOficiosActivos();

    @Results(
            id="CobroMap", 
            value = {
                @Result(property = "idUser",        column = "id_user"),
                @Result(property = "numTarjeta",        column = "num_tarjeta")
        })
    @Select("select * from pago_detalle where id_user=#{id}")
    PagoDetalle getDatosDePago(int id);

    @Insert("INSERT INTO pago_detalle VALUES("
            + "null,"
            + " #{idUser},"
            + " #{nombre},"
            + " #{numTarjeta},"
            + " #{vencimiento},"
            + " #{ccv})")
    void insertDatosBancarios(PagoDetalle pagoDetalle);
    
    @Update("update pago_detalle set "
            + " nombre=#{nombre},"
            + " num_tarjeta=#{numTarjeta},"
            + " vencimiento=#{vencimiento},"
            + " ccv=#{ccv}"
            + " where id_user=#{idUser}")
    void updateDatosBancarios(PagoDetalle pagoDetalle);

}
