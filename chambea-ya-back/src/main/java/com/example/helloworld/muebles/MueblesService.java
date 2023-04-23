package com.example.helloworld.muebles;

import java.util.List;

public interface MueblesService {

	List<Mueble> getAll();

	Mueble cal(int id, String nom, String col, String pre, String ago);
}
