package com.portfolio.CMaza.Service;

import com.portfolio.CMaza.Entity.Persona;
import com.portfolio.CMaza.Interface.IPersonaService;
import com.portfolio.CMaza.Repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImplPersonaService implements IPersonaService {
    @Autowired IPersonaRepository ipersonaRepository;
    
    @Override
    public List<Persona> traerPersonas() {
        List<Persona> persona = ipersonaRepository.findAll();
        return  persona;
    }

    @Override
    public void guardarPersona(Persona persona) {
      ipersonaRepository.save(persona);
    }

    @Override
    public void borrarPersona(Long id) {
       ipersonaRepository.deleteById(id);
    }

    @Override
    public Persona traerPersona(Long id) {
        Persona persona = ipersonaRepository.findById(id).orElse(null);
        return persona;
    }
    
}
