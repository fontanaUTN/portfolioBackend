package com.portfolio.fontana.Service;

import com.portfolio.fontana.Entity.Knowledge;
import com.portfolio.fontana.Repository.RKnowledge;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SKnowledge {
    @Autowired
    RKnowledge rKnowledge;
      
    public List<Knowledge> list() {
        return rKnowledge.findAll();
    }
    
    public Optional<Knowledge> getOne(int id){
        return rKnowledge.findById(id);
    }
    
    public Optional<Knowledge> getByNameK(String nameK){
        return rKnowledge.findByNameK(nameK);
    }
    
    public void save(Knowledge knowledge){
        rKnowledge.save(knowledge);
    }
    
    public void delete(int id){
        rKnowledge.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rKnowledge.existsById(id);
    }
    
    public boolean existsByNameK(String nameK){
        return rKnowledge.existsByNameK(nameK);
    }
}
