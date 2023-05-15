package com.portfolio.fontana.Controller;

import com.portfolio.fontana.Dto.dtoPeople;
import com.portfolio.fontana.Entity.People;
import com.portfolio.fontana.Security.Controller.Mensaje;
import com.portfolio.fontana.Service.ImpPeopleService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/people")
@CrossOrigin(origins = "https://federico.progresodigital.net")
public class PeopleController {
    @Autowired ImpPeopleService peopleService;
    
    @GetMapping("/list")
    public ResponseEntity<List<People>> list() {
        List<People> list = peopleService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<People> getById(@PathVariable("id") int id) {
        if(!peopleService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe id"), HttpStatus.BAD_REQUEST);
        }
        
        People people = peopleService.getOne(id).get();
        return new ResponseEntity(people, HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPeople dtopeople) {
        if(!peopleService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe id"), HttpStatus.NOT_FOUND);
        }
        if(peopleService.existsByName(dtopeople.getName()) && peopleService.getByName(dtopeople.getName()).get().getId() != id) {
            return new ResponseEntity( new Mensaje("El nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtopeople.getName())){
            return new ResponseEntity(new Mensaje("Complete todos los campos"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtopeople.getDescription())){
            return new ResponseEntity(new Mensaje("Complete todos los campos"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtopeople.getImage())){
            return new ResponseEntity(new Mensaje("Complete todos los campos"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtopeople.getLastname())){
            return new ResponseEntity(new Mensaje("Complete todos los campos"), HttpStatus.BAD_REQUEST);
        }
        
        People people = peopleService.getOne(id).get();
        
        people.setName(dtopeople.getName());
        people.setLastname(dtopeople.getLastname());
        people.setDescription(dtopeople.getDescription());
        people.setImage(dtopeople.getImage());
        
        peopleService.save(people);
        
        return new ResponseEntity(new Mensaje("Usuario actualizado"), HttpStatus.OK);
    }
    
}
