package com.portfolio.fontana.Service;

import com.portfolio.fontana.Entity.People;
import com.portfolio.fontana.Repository.IPeopleRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpPeopleService {
    @Autowired IPeopleRepository ipeopleRepository;

    public List<People> list(){
       return ipeopleRepository.findAll();
    }
   
    public Optional<People> getOne(int id) {
        return ipeopleRepository.findById(id);
    }
    
    public Optional<People> getByName(String name) {
        return ipeopleRepository.findByName(name);
    }
    
    public void save(People people) {
        ipeopleRepository.save(people);
    }
    
    public void delete(int id) {
        ipeopleRepository.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return ipeopleRepository.existsById(id);
    }
    
    public boolean existsByName(String name) {
        return ipeopleRepository.existsByName(name);
    }
}
