package com.example.helloworld.productos;

import java.util.List;

import com.example.helloworld.productos.model.Producto;
import com.example.helloworld.productos.model.ResultadoConsulta;

public interface ProductoService {
    /**
     * Retorna todos los productos guardados en la base de datos.
     * @return Lista de Productos provenientes de la base de datos.
     */
    List<Producto> obtenTodosLosProductos();
    
    /**
     * Regresa un objeto de tipo 'Producto' el cual
     * tiene por id, el argumento pasado a este método.
     * Si no existe ningún producto con ese id, este método
     * regresa un producto nulo (null)
     * 
     * @param id Llave del producto a ser buscado
     * @return Producto asociado al id proporcionado
     */
    Producto obtenProductoPorId(int id);
    
    /**
     * Busca el producto dado y si no está en la base de datos, 
     * lo inserta, pero si está en la base, lo actualiza.
     * 
     * @param producto Producto a ser insertado o actualizado
     */
    void guarda(Producto producto);
    
    /**
     * Elimina el producto cuyo id es el dado.
     * Si no existe ningún producto con ese di, no hace nada.
     * 
     * @param id Entero asociado a un posible producto.
     */
    void elimina(int id);
    
    ResultadoConsulta getBigResult(int id);
}
