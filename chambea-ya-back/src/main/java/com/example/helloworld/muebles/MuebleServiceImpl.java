package com.example.helloworld.muebles;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class MuebleServiceImpl implements MueblesService {
	    private MuebleMapper muebleMapper;
	    
	    public MuebleServiceImpl(MuebleMapper muebleMapper) {
	        this.muebleMapper = muebleMapper;
	    }
	    public Mueble cal(int id, String nom, String col, String pre, String ago) {
	        return muebleMapper.getById(7534);
	    }
	    @Override
	    public List<Mueble> getAll() { 
	        return muebleMapper.getAll();
	    }


}
