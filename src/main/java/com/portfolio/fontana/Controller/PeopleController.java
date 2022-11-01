package com.portfolio.fontana.Controller;

import com.portfolio.fontana.Entity.People;
import com.portfolio.fontana.Interfase.IPeopleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://portfolio-frontend-cc3de.web.app")
public class PeopleController {
    @Autowired IPeopleService ipeopleService;

    @GetMapping("/people/show")
    public List<People> getPeople() {
        return ipeopleService.getPeople();
    }
    
    @PreAuthorize("hasRole('ADMIN)")
    @PostMapping("/people/create")
    public String createPeople(@RequestBody People people){
        ipeopleService.savePeople(people);
        return "La persona fue creada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN)")
    @DeleteMapping("/people/delete/id={id}")
    public String deletePeople(@PathVariable Long id){
        ipeopleService.deletePeople(id);
        return "La persona fue eliminada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN)")
    @PutMapping("/people/edit/id={id}")
    public People editPeople(@PathVariable Long id,
                             @RequestParam("name") String newName,
                             @RequestParam("lastname") String newLastname,
                             @RequestParam("image") String newImage){
        People people = ipeopleService.findPeople(id);
        
        people.setName(newName);
        people.setLastname(newLastname);
        people.setImage(newImage);
        
        ipeopleService.savePeople(people);
        return people;
    }
    
    @GetMapping("/people/get/profile")
    public People findPeople() {
        return ipeopleService.findPeople((long)1);
    }
}
