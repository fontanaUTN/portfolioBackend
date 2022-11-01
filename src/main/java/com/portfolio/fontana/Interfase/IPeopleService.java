package com.portfolio.fontana.Interfase;

import com.portfolio.fontana.Entity.People;
import java.util.List;

public interface IPeopleService {
    //Traer pesona
    public List<People> getPeople();
    
    //Guerdar una persona
    public void savePeople(People people);
    
    //eliminar un usuario por id
    public void deletePeople(Long id);
    
    //Buscar una persona por id
    public People findPeople(Long id);
}
