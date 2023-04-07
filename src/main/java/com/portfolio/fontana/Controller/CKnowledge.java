
package com.portfolio.fontana.Controller;

import com.portfolio.fontana.Dto.dtoKnowledge;
import com.portfolio.fontana.Entity.Knowledge;
import com.portfolio.fontana.Security.Controller.Mensaje;
import com.portfolio.fontana.Service.SKnowledge;
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
@RequestMapping("/services")
@CrossOrigin(origins = "*")
public class CKnowledge {
    @Autowired
    SKnowledge sKnowledge;
    
    @GetMapping("/list")
    public ResponseEntity<List<Knowledge>> list(){
        List<Knowledge> list = sKnowledge.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Knowledge> getById(@PathVariable("id") int id){
        if(!sKnowledge.existsById(id)){
            return new ResponseEntity(new Mensaje("no existe ese id"), HttpStatus.BAD_REQUEST);
        }
        
        Knowledge knowledge = sKnowledge.getOne(id).get();
        
        return new ResponseEntity(knowledge, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sKnowledge.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe ese id"), HttpStatus.NOT_FOUND);
        }
        
        sKnowledge.delete(id);
        return new ResponseEntity(new Mensaje("Eliminado correctamente"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoKnowledge dtoknowledge){
        if(StringUtils.isBlank(dtoknowledge.getNameK())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoknowledge.getDescriptionK())){
            return new ResponseEntity(new Mensaje("La descripcion es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoknowledge.getSkillK())){
            return new ResponseEntity(new Mensaje("La skill es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoknowledge.getImageK())){
            return new ResponseEntity(new Mensaje("La imagen es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if(sKnowledge.existsByNameK(dtoknowledge.getNameK())){
            return new ResponseEntity(new Mensaje("El nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Knowledge knowledge = new Knowledge(
                dtoknowledge.getNameK(),
                dtoknowledge.getDescriptionK(),
                dtoknowledge.getImageK(),
                dtoknowledge.getSkillK()
        );
        
        sKnowledge.save(knowledge);
        return new ResponseEntity(new Mensaje("Servicio creado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoKnowledge dtoknowledge){
        if(!sKnowledge.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe ese id"), HttpStatus.NOT_FOUND);
        }
        
        if(sKnowledge.existsByNameK(dtoknowledge.getNameK()) && sKnowledge.getByNameK(dtoknowledge.getNameK()).get().getId() != id){
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoknowledge.getDescriptionK())){
            return new ResponseEntity(new Mensaje("La descripcion no debe estar vacia"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoknowledge.getImageK())){
            return new ResponseEntity(new Mensaje("La imagen no debe estar vacia"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoknowledge.getSkillK())){
            return new ResponseEntity(new Mensaje("La skill no debe estar vacia"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoknowledge.getNameK())){
            return new ResponseEntity(new Mensaje("El nombre no debe estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Knowledge knowledge = sKnowledge.getOne(id).get();
        
        knowledge.setNameK(dtoknowledge.getNameK());
        knowledge.setDescriptionK(dtoknowledge.getDescriptionK());
        knowledge.setImageK(dtoknowledge.getImageK());
        knowledge.setSkillK(dtoknowledge.getSkillK());
        
        sKnowledge.save(knowledge);
        
        return new ResponseEntity(new Mensaje("datos actualizados"), HttpStatus.OK);
    }
    
}
