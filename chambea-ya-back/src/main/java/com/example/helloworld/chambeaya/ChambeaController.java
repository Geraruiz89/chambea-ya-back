package com.example.helloworld.chambeaya;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloworld.chambeaya.model.Usuario;
import com.example.helloworld.chambeaya.model.UsuarioAnuncio;
import com.example.helloworld.chambeaya.model.UsuarioDatosP;
import com.example.helloworld.chambeaya.model.UsuarioQbits;
import com.example.helloworld.productos.InvokeRemoteRestService;
import com.example.helloworld.chambeaya.model.Anuncio;
import com.example.helloworld.chambeaya.model.Estados;
import com.example.helloworld.chambeaya.model.Oficios;
import com.example.helloworld.chambeaya.model.PagoDetalle;
import com.example.helloworld.chambeaya.model.JwtBody;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping(value="/chambea/api")

public class ChambeaController {
    private ChambeaService chambeaService;
    private AnuncioService anuncioService;
    private InvokeRemoteRestService invokeRemoteRestService;
    
    public ChambeaController( ChambeaService chambeaService, AnuncioService anuncioService, InvokeRemoteRestService invokeRemoteRestService){
        this.chambeaService = chambeaService;
        this.anuncioService = anuncioService;
        this.invokeRemoteRestService = invokeRemoteRestService;
    }
    
    @ApiOperation(
            value = "PruebaDeConexion::Prueba",
            notes = "Devuelve true si existe conexion")
    @GetMapping(
            value= "/prueba-de-conexion", 
            produces = "application/json; charset=utf-8")
    public Boolean connectionText() {
        return (true);
    }
    
    @ApiOperation(
            value = "TodosLosOficiosActivos::DatosDeOficios",
            notes = "Obtener la lista de oficios")
    @GetMapping(
            value= "/oficios", 
            produces = "application/json; charset=utf-8")
    public List<Oficios> datosOficios() {
        return this.chambeaService.getDatosOficios();
    }
    
    @ApiOperation(
            value = "TodosLosEstadosDeLaRepublica::DatosDeEstados",
            notes = "Obtener la lista de Estados")
    @GetMapping(
            value= "/estados", 
            produces = "application/json; charset=utf-8")
    public List<Estados> datosEstados() {
        return this.chambeaService.getDatosEstados();
    }
    
    @ApiOperation(
            value = "UserDatos::Datos",
            notes = "Obtener la informacion del usuario por su Id")
    @GetMapping(
            value= "/user", 
            produces = "application/json; charset=utf-8")
    public Usuario datosTotales(int id) {
        return this.chambeaService.getDatos(id);
    }
    
    @ApiOperation(
            value = "CreaGuardaActualiza::DatosDeUsuario",
            notes = "Crea al usuario al confirmar su registro, "
                    + "guarda un usuario o actualiza su informacion personal")
    @PostMapping(
            value = "/guarda",
            produces = "application/json; charset=utf-8")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Se agrego o actualizo correctamente"),
            @ApiResponse(code = 400, message = "Error al guardar")
    })
    public void guarda ( 
            @RequestBody Usuario ccr) {
        this.chambeaService.guarda(ccr);
    }
    
    @ApiOperation(
            value = "CreaUsuarioDeQbits::DatosDeUsuarioQbits",
            notes = "Crea al usuario al logearse con su cuenta de qbits, "
                    + "guarda un usuario de qbits")
    @PostMapping(
            value = "/guardaqbits",
            produces = "application/json; charset=utf-8")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Se agrego al usuario correctamente"),
            @ApiResponse(code = 400, message = "Error al guardar")
    })
    public String guardaUsuarioQbits ( 
            @RequestBody UsuarioQbits ccr) {
        return this.chambeaService.guardaQbits(ccr);
    }
    
    @ApiOperation(
            value = "Actualiza::DatosDeUsuarioPorElUsuario",
            notes = "Actualiza su informacion personal del usuario")
    @PostMapping(
            value = "/guarda-datos-personales",
            produces = "application/json; charset=utf-8")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Se actualizo correctamente"),
            @ApiResponse(code = 400, message = "Error al guardar")
    })
    public String guardaUserDatos ( 
            @ApiParam(name = "jwt", value = "token jwt")
            @RequestHeader String jwt,
            @ApiParam(name = "usuario", value = "objeto usuario")
            @RequestBody UsuarioDatosP ccr) {
        JwtBody response = invokeRemoteRestService.checkJwt(jwt);
            if (response.getUserId() == ccr.getIdUser()) {
                this.chambeaService.guardaDatosPersonales(ccr);
                return ("Datos guardados correctamente");
            }
        return ("Error al guardadar datos");
    }
    
    @ApiOperation(
            value = "AnuncioUserDatos::AnuncioDatos",
            notes = "Obtener la informacion del anuncio del usuario por su Id")
    @GetMapping(
            value= "/anuncio-mi", 
            produces = "application/json; charset=utf-8")
    public Anuncio datosDeAnuncio(int id) {
        return this.anuncioService.getDatosAnuncioIdUser(id);
    }
    
    @ApiOperation(
            value = "AnuncioIdDatos::AnuncioDatos",
            notes = "Obtener la informacion del anuncio por su Id")
    @GetMapping(
            value= "/anuncio-id", 
            produces = "application/json; charset=utf-8")
    public Anuncio datosDeAnuncioId(int id) {
        return this.anuncioService.getDatosAnuncioId(id);
    }
    
    @ApiOperation(
            value = "AnuncioProcesado::AnuncioDatosProcesados",
            notes = "Obtener la informacion del anuncio por su Id")
    @GetMapping(
            value= "/anuncio-id-comp", 
            produces = "application/json; charset=utf-8")
    public UsuarioAnuncio datosDeAnuncioCompletos(int id) {
        return this.anuncioService.getDatosAnuncioCompletos(id);
    }
    
    @ApiOperation(
            value = "CreaGuardaActualiza::DatosDeAnuncio",
            notes = "Crea el anuncio al guardar en el front, "
                    + "guarda o actualiza la informacion del anuncio")
    @PostMapping(
            value = "/guarda-anuncio",
            produces = "application/json; charset=utf-8")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Se agrego o actualizo correctamente"),
            @ApiResponse(code = 400, message = "Error al guardar")
    })
    public String guardaAnuncio ( 
            @RequestBody Anuncio ccr,
            @ApiParam(name = "jwt", value = "token jwt")
            @RequestHeader String jwt) {
        JwtBody response = invokeRemoteRestService.checkJwt(jwt);
            if (response.getUserId() == ccr.getIdUser()) {
                this.anuncioService.guarda(ccr);
                return ("Datos guardados correctamente");
            }
        return ("Error al guardadar datos");
    }
    
    @ApiOperation(
            value = "DatosBancarios::DatosBancariosDeUsuario",
            notes = "Obtener los datos bancarios de u usuario")
    @GetMapping(
            value= "/pago-detalle", 
            produces = "application/json; charset=utf-8")
    public PagoDetalle datosPagoDetalle(int id,
            @ApiParam(name = "jwt", value = "token jwt")
            @RequestHeader String jwt) {
        JwtBody response = invokeRemoteRestService.checkJwt(jwt);
            if (response.getUserId() == id) {
                return this.chambeaService.getDatosPagoDetalle(id);
            }
        PagoDetalle ceros = new PagoDetalle(0, 0, "Error de validacion", null, null, 0);
        return ceros;
    }
    
    @PostMapping(
            value = "/guarda-informacio-bancaria",
            produces = "application/json; charset=utf-8")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Se agrego o actualizo correctamente"),
            @ApiResponse(code = 400, message = "Error al guardar")
            })
    public String guardaDatosBancarios ( 
            @RequestBody PagoDetalle pagoDetalle,
            @ApiParam(name = "jwt", value = "token jwt")
            @RequestHeader String jwt) {
        JwtBody response = invokeRemoteRestService.checkJwt(jwt);
            if (response.getUserId() == pagoDetalle.getIdUser()) {
                this.chambeaService.guardaDatosBancarios(pagoDetalle);
                return ("Datos guardados correctamente");
            }
        return ("Error al guardar los datos");
    }
    @PostMapping(
            value = "/guarda-imagen-principal",
            produces = "application/json; charset=utf-8")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Se agrego o actualizo correctamente"),
            @ApiResponse(code = 400, message = "Error al guardar")
            })
    public String guardaImagenPrincipal( 
            @RequestParam String enc,
            @ApiParam(name = "jwt", value = "token jwt")
            @RequestHeader String jwt,
            @RequestParam int id) {
        JwtBody response = invokeRemoteRestService.checkJwt(jwt);
            if (response.getUserId() == id) {
                this.anuncioService.updateImagenPrincipal(enc, id);
                return ("Datos guardados correctamente");
            }
        return ("Error al guardar los datos");
    }
}
