package com.example.helloworld.productos;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloworld.personas.Persona;
import com.example.helloworld.productos.model.ResultadoConsulta;

@RestController
@RequestMapping(value="/hola")
public class ProductoController {
    private ProductoService productoService;
    private LoginService loginService;
    private InvokeRemoteRestService invokeService;
    
    public ProductoController(ProductoService productoService, LoginService loginService, InvokeRemoteRestService invokeService) {
        this.productoService = productoService;
        this.loginService = loginService;
        this.invokeService = invokeService;
    }
    
    @GetMapping(
            value="/dameProducto", 
            produces = "application/json; charset=utf-8")
    public ResultadoConsulta listaTotal(int id) {
        return this.productoService.getBigResult(id);
    }
    
    @GetMapping(
            value="/login", 
            produces = "application/json; charset=utf-8")
    public String fakeLogin(
            @RequestParam String user, 
            @RequestParam String password) {
        return loginService.login(user, password);
    }
    
    @GetMapping(
            value="/cambia", 
            produces = "application/json; charset=utf-8")
    public List<String> fakeCambiaPassword(
            @RequestHeader String tokenDado,
            @RequestParam String nuevoPassword) {
        return loginService.cambia(tokenDado, nuevoPassword);
    }
    
    @PostMapping(
            value = "/prueba",
            produces = "application/json; charset=utf-8")
    public Object Pruebita(
            @RequestHeader("jwt") String jwt, 
            @RequestBody Persona ccr) {
        // pido ccr sólo para ejemplificar el uso del body
        return invokeService.checkJwt(jwt);
    }
}
