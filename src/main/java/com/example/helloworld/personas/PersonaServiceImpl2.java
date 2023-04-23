package com.example.helloworld.personas;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service(value = "primeraImplementacionYYY")
public class PersonaServiceImpl2 implements PersonaService {
    private PersonaMapper personaMapper;
    
    public PersonaServiceImpl2(PersonaMapper personaMapper) {
        this.personaMapper = personaMapper;
    }
    
    public Persona calcula(String ua, String col, String v1, String v2, String v3) {
        Persona p = personaMapper.getById(2233);
        float nuevo = 2*p.getSueldo();
        if(nuevo>150) {
            p.setNombre("super adinerado");
        } else {
            p.setApPat("muy pobre");
        }
        p.setSueldo(nuevo);
        personaMapper.insert(p);
        return p;
    }
    @Override
    public List<Persona> getAll() {
        return personaMapper.getAll();
    }

}
