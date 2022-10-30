package com.portfolio.CMaza.Service;

import com.portfolio.CMaza.Entity.Persona;
import com.portfolio.CMaza.Repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonaService {

    @Autowired
    IPersonaRepository iPersonaRepository;

    //Mét. para guardar persona, borrar persona, validar por Id/por nombre
    public List<Persona> list() {
        return iPersonaRepository.findAll();
    }
        
    public Optional<Persona> getOne(int id) {
        return iPersonaRepository.findById(id);
    }
    
    public Optional<Persona> getByNombre(String nombre) {
        return iPersonaRepository.findByNombre(nombre);
    }
    
    public void save(Persona persona) {
        iPersonaRepository.save(persona);
    }

    public void delete(int id) {
        iPersonaRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return iPersonaRepository.existsById(id);
    }

    public boolean existsByNombre(String nombre) {
        return iPersonaRepository.existsByNombre(nombre);
    }

}
