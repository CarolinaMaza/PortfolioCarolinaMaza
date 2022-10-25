package com.portfolio.CMaza.Security.Service;

import com.portfolio.CMaza.Security.Entity.Rol;
import com.portfolio.CMaza.Security.Enums.RolNombre;
import com.portfolio.CMaza.Security.Repository.iRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Notación transaccional permite persistencia en caso de error al grabar datos en bd.
@Service
@Transactional
public class RolService {
    @Autowired
    iRolRepository irolRepository;
    
    //Mét. propios de la clase que validan la existencia del rol y guardan el rol
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return irolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        irolRepository.save(rol);
    }
}