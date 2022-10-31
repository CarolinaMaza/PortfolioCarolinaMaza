
package com.portfolio.CMaza.Controller;

import com.portfolio.CMaza.Dto.SoftSkillDto;
import com.portfolio.CMaza.Entity.SoftSkill;
import com.portfolio.CMaza.Security.Controller.Mensaje;
import com.portfolio.CMaza.Service.SoftSkillService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"https://frontcaromaza.web.app", "http://localhost:4200"})
@RequestMapping("/softskill")
public class SoftSkillController {
    //Clase que permite crear, buscar, editar, borrar los datos de skill del portfolio

    @Autowired
    SoftSkillService softSkillService;

    //Mét. para traer lista de skills
    @GetMapping("/list")
    public ResponseEntity<List<SoftSkill>> list() {
        List<SoftSkill> list = softSkillService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    //Mét. para traer skill según ID
    @GetMapping("/detail/{id}")
    public ResponseEntity<SoftSkill> getById(@PathVariable("id") int id) {
        if (!softSkillService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }

        SoftSkill softSkill = softSkillService.getOne(id).get();
        return new ResponseEntity(softSkill, HttpStatus.OK);
    }

    //Mét. para eliminar skill según ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!softSkillService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID del skill no existe"), HttpStatus.NOT_FOUND);
        }
        softSkillService.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminada correctamente"), HttpStatus.OK);
    }

    //Mét. para crear skill previas validaciones
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody SoftSkillDto softSkillDto) {
        if (StringUtils.isBlank(softSkillDto.getNombreSf())) {
            return new ResponseEntity(new Mensaje("El nombre de la skill es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(Integer.toString(softSkillDto.getPorcentajeSf()))) {
            return new ResponseEntity(new Mensaje("El porcenteja de la skill es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        // public SoftSkill(String nombreSf, int porcentajeSf)
        SoftSkill softSkill = new SoftSkill(
                softSkillDto.getNombreSf(),
                softSkillDto.getPorcentajeSf()
        );
        softSkillService.save(softSkill);
        return new ResponseEntity(new Mensaje("Skill creada correctamente"), HttpStatus.OK);

    }

    //Mét. que actualiza skill según ID previas validaciones
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody SoftSkillDto softSkillDto) {
        if (!softSkillService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if (StringUtils.isBlank(softSkillDto.getNombreSf())) {
            return new ResponseEntity(new Mensaje("El nombre de la skill es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(Integer.toString(softSkillDto.getPorcentajeSf()))) {
            return new ResponseEntity(new Mensaje("El porcenteja de la skill es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        // public SoftSkill(String nombreSf, int porcentajeSf)
        SoftSkill softSkill = softSkillService.getOne(id).get();
        softSkill.setNombreSf(softSkillDto.getNombreSf());
        softSkill.setPorcentajeSf(softSkillDto.getPorcentajeSf());

        softSkillService.save(softSkill);

        return new ResponseEntity(new Mensaje("Skill actualizada correctamente"), HttpStatus.OK);
    }
}
