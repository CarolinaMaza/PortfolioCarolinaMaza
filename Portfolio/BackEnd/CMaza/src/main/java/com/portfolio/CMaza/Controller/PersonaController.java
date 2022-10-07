package com.portfolio.CMaza.Controller;

import com.portfolio.CMaza.Entity.Persona;
import com.portfolio.CMaza.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    
    @GetMapping ("/personas/traer")
    public List <Persona> traerPersonas(){
        return ipersonaService.traerPersonas();
    }
    
    @PostMapping ("/personas/crear")
    public String crearPersona(@RequestBody Persona persona) {
        ipersonaService.guardarPersona(persona);
        return "La persona fue creada correctamente";
    }
    
    @DeleteMapping ("/personas/borrar/(id)")
    public String borrarPersona(@PathVariable Long id) {
        ipersonaService.borrarPersona(id);
        return "La persona fue eliminada correctamente";
    }
    
    // URL:PUERTO/personas/editar/id?nombre="NuevoNombre"&apellido="NuevoApellido"&img="NuevoString"
    @PutMapping("/personas/editar/(id)")
    public Persona editarPersona(@PathVariable Long id,
                                 @RequestParam ("nombre") String nuevoNombre,
                                 @RequestParam ("apellido") String nuevoApellido,
                                 @RequestParam ("img") String nuevoImg){
        Persona persona = ipersonaService.traerPersona(id);
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);
        
        ipersonaService.guardarPersona (persona);
        return persona;
    }
    
}
    
