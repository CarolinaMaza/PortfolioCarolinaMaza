package com.portfolio.CMaza.Interface;

import com.portfolio.CMaza.Entity.Persona;
import java.util.List;

public interface IPersonaService {
    //Método para traer una lista de personas
    public List <Persona> traerPersonas ();
    
    //Método para guardar una persona en la lista
    public void guardarPersona(Persona persona);
            
    //Método para eliminar una persona en la lista
    public void borrarPersona (Long id);
    
    //Método para buscar una persona en la lista
    public Persona traerPersona (Long id);
    
}
