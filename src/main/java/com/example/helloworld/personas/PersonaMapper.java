package com.example.helloworld.personas;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaMapper {
    @Select("SELECT * FROM Persona")
    public List<Persona> getAll();
    
    @Select("SELECT * FROM Persona WHERE id = #{id} ")
    public Persona getById(int id);

    @Insert("INSERT INTO Persona VALUES(#{id},#{nombre},#{apPat},#{apMaterno},#{sueldo},#{genero})")
    public void insert(Persona p);
    
    @Update("UPDATE Persona SET id=#{id}, nombre=#{nombre}, apPat=#{apPat}, apMaterno=#{apMaterno}, sueldo=#{sueldo}, genero=#{genero} ")
    public void update(Persona p);
    
    @Delete("DELETE FROM Persona WHER id=#{idPersona}")
    public void delete(int idPersona);
}
