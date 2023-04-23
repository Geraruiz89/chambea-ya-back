package com.example.helloworld.personas;

import java.util.List;

public interface PersonaService {
    Persona calcula(String ua, String col, String v1, String v2, String v3);
	List<Persona> getAll();
}
