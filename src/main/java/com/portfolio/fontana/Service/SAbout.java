package com.portfolio.fontana.Service;

import com.portfolio.fontana.Entity.About;
import com.portfolio.fontana.Repository.RAbout;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SAbout {
    @Autowired
    RAbout rAbout;
    
    public List<About> list() {
        return rAbout.findAll();
    }
    
    public Optional<About> getOne(int id) {
        return rAbout.findById(id);
    }
    
    public Optional<About> getByText(String text) {
        return rAbout.findByText(text);
    }
    
    public void save(About about) {
        rAbout.save(about);
    }
    
    public void delete(int id) {
        rAbout.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return rAbout.existsById(id);
    }
    
    public boolean existsByText(String text) {
        return rAbout.existsByText(text);
    }
}
