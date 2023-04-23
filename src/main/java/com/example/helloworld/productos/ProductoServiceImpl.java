package com.example.helloworld.productos;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.helloworld.productos.model.CaracteristicaProducto;
import com.example.helloworld.productos.model.ImagenProducto;
import com.example.helloworld.productos.model.Producto;
import com.example.helloworld.productos.model.ResultadoConsulta;

@Primary
@Service
public class ProductoServiceImpl implements ProductoService{
    private ProductoMapper productMapper;
    
    public ProductoServiceImpl(ProductoMapper productMapper) {
        this.productMapper = productMapper;
    }
    public List<Producto> obtenTodosLosProductos() {
        return productMapper.getAll();
    }
    public Producto obtenProductoPorId(int id) {
        return productMapper.selectById(id);
    }
    public ResultadoConsulta getBigResult(int id) {
        Producto producto = productMapper.selectById(id);
        List<CaracteristicaProducto> caracteristicas = productMapper.getAllCaractForProducto(id);
        List<ImagenProducto> imagenes = productMapper.getAllImagesForProducto(id);
        
        List<String> carRes = caracteristicas.stream().map(p-> p.getDescripcion()).collect(Collectors.toList());
        List<String> imgRes = imagenes.stream().map(p -> p.getNombre()).collect(Collectors.toList());

        return new ResultadoConsulta(producto, carRes, imgRes);
    }
    public void guarda(Producto producto) {
        int id = producto.getId();
        Producto encontrado = this.obtenProductoPorId(id);
        // si NO hay ningún renglón en la tabla "Persona",cuyo id sea
        // el parámetro que recibe el método 'ObtenProductoPorId'
        // entonces la variable "encontrado" será ingual a: null
        if(encontrado==null) {
            productMapper.insert(producto);
        } else {
            productMapper.update(producto);
        }
    }
    public void elimina(int id) {
        productMapper.delete(id);
    }
}
