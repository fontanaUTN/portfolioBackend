package com.portfolio.fontana.Controller;

import com.portfolio.fontana.Dto.dtoAbout;
import com.portfolio.fontana.Entity.About;
import com.portfolio.fontana.Security.Controller.Mensaje;
import com.portfolio.fontana.Service.SAbout;
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
@RequestMapping("/about")
@CrossOrigin(origins = "*")
public class CAbout {
    @Autowired
    SAbout sAbout;
    
    @GetMapping("/list")
    public ResponseEntity<List<About>> list(){
        List<About> list = sAbout.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<About> getById(@PathVariable("id") int id){
        if(!sAbout.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        About about = sAbout.getOne(id).get();
        return new ResponseEntity(about, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sAbout.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sAbout.delete(id);
        return new ResponseEntity(new Mensaje("parrafo eliminado"), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoAbout dtoabout){      
        if(StringUtils.isBlank(dtoabout.getText()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sAbout.existsByText(dtoabout.getText()))
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        
        About experience = new About(dtoabout.getText(), dtoabout.getExtra());
        sAbout.save(experience);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoAbout dtoabout){
        //Validamos si existe el ID
        if(!sAbout.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(sAbout.existsByText(dtoabout.getText()) && sAbout.getByText(dtoabout.getText()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Ese parrafo ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoabout.getText()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        About about = sAbout.getOne(id).get();
        about.setText(dtoabout.getText());
        
        sAbout.save(about);
        return new ResponseEntity(new Mensaje("Parrafo actualizada"), HttpStatus.OK);
             
    }
}
