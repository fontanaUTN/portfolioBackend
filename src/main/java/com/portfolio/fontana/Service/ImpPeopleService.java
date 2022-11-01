package com.portfolio.fontana.Service;

import com.portfolio.fontana.Entity.People;
import com.portfolio.fontana.Interfase.IPeopleService;
import com.portfolio.fontana.Repository.IPeopleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpPeopleService implements IPeopleService {
    @Autowired IPeopleRepository ipeopleRepository;
    
    @Override
    public List<People> getPeople() {
        List<People> people = ipeopleRepository.findAll();
        return people;
    }

    @Override
    public void savePeople(People people) {
        ipeopleRepository.save(people);
    }

    @Override
    public void deletePeople(Long id) {
        ipeopleRepository.deleteById(id);
    }

    @Override
    public People findPeople(Long id) {
        People people = ipeopleRepository.findById(id).orElse(null);
        return people;
    }
    
}
