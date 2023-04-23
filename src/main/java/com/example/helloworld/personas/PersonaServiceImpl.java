package com.example.helloworld.personas;

import java.util.List;
import org.springframework.stereotype.Service;

@Service(value = "primeraImplementacion")
public class PersonaServiceImpl implements PersonaService {
    private PersonaMapper personaMapper;
    
    public PersonaServiceImpl(PersonaMapper personaMapper) {
        this.personaMapper = personaMapper;
    }
    public Persona calcula(String ua, String col, String v1, String v2, String v3) {
        return personaMapper.getById(7534);
    }
    @Override
    public List<Persona> getAll() {
        return personaMapper.getAll();
    }
}
