
package com.portfolio.CMaza.Service;

import com.portfolio.CMaza.Entity.HardSkill;
import com.portfolio.CMaza.Repository.IHardSkillRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HardSkillService {

    @Autowired
    IHardSkillRepository iHardSkillRepository;

    //Mét. para traer listado de skills, obtener uno por ID/por nombre, guardar, borrar, validar si existe por ID/por nombre
    public List<HardSkill> list() {
        return iHardSkillRepository.findAll();
    }

    public Optional<HardSkill> getOne(int id) {
        return iHardSkillRepository.findById(id);
    }

    public Optional<HardSkill> getByNombre(String nombre) {
        return iHardSkillRepository.findByNombreHd(nombre);
    }

    public void save(HardSkill hardSkill) {
        iHardSkillRepository.save(hardSkill);
    }

    public void delete(int id) {
        iHardSkillRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return iHardSkillRepository.existsById(id);
    }

    public boolean existsByNombre(String nombre) {
        return iHardSkillRepository.existsByNombreHd(nombre);
    }
}
