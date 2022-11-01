package com.portfolio.fontana.Security.Service;

import com.portfolio.fontana.Security.Entity.User;
import com.portfolio.fontana.Security.Respository.iUserRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
    @Autowired
    iUserRepository iuserRepository;
    
    public Optional<User> getByNameUser(String nameUser) {
        return iuserRepository.findByNameUser(nameUser);
    }
    
    public boolean existsByNameUser(String nameUser) {
        return iuserRepository.existsByNameUser(nameUser);
    }
    
    public boolean existsByEmail(String email) {
        return iuserRepository.existsByEmail(email);
    }
    
    public void save (User user) {
        iuserRepository.save(user);
    }
}
