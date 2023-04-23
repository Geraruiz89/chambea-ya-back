package com.example.helloworld.productos;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.example.helloworld.productos.model.CaracteristicaProducto;
import com.example.helloworld.productos.model.ImagenProducto;
import com.example.helloworld.productos.model.Producto;

@Repository
public interface ProductoMapper {
    @Results(
        id="ProductoMap", 
        value = {
            @Result(property = "totalStars",        column = "total_stars"),
            @Result(property = "votosTotales",      column = "votos_totales"),
            @Result(property = "totalProd",         column = "total_prod"),
            @Result(property = "totalVentas",       column = "total_ventas"),
            @Result(property = "numVentas",         column = "num_ventas"),
            @Result(property = "idImagenPrincipal", column = "id_imagen_principal"),
            @Result(property = "nombreImagenPrincipal", column = "nombre_imagen_principal"),
            @Result(property = "especDia",          column = "espec_dia")
    })
    @Select("select * from producto")
    List<Producto> getAll();
    
    @ResultMap("ProductoMap")
    @Select("select * from producto where id=#{id}")
    Producto selectById(int id);
    
    @Insert("insert into producto values(#{id}, #{nombre}, ...)")
    void insert(Producto producto);
    
    @Update("update producto set nombre=#{nombre}, ... where id=#{id}")
    void update(Producto producto);
    
    @Delete("delete from producto where id=#{id}")
    void delete(int id);
    
    @Results(value = {
            @Result(property = "idProducto", column = "id_producto")})
    @Select("select id, id_producto, nombre, activa from imagen_producto where id_producto=#{idProducto}")
    List<ImagenProducto> getAllImagesForProducto(int idProducto);

    @Results(value = {
            @Result(property = "idProducto", column = "id_producto")})
    @Select("select id, id_producto, descripcion, activa from caracteristica_producto where id_producto=#{idProducto}")
    List<CaracteristicaProducto> getAllCaractForProducto(int idProducto);

}
