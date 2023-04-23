package com.example.helloworld.muebles;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


	@RestController
	@RequestMapping(value="/pro")
public class MuebleController {
		private MueblesService mueblesService;
	    
	    public  MuebleController( MueblesService mueblesService) {
	        this.mueblesService = mueblesService;
	    }
    
	    @GetMapping(
	            value= "/muebles", 
	            produces = "application/json; charset=utf-8")
	    public List<Mueble> muebles() {
	        return mueblesService.getAll();
	    }
	}


