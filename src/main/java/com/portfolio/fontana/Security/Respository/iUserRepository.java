package com.portfolio.fontana.Security.Respository;

import com.portfolio.fontana.Security.Entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iUserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByNameUser(String nameUser);
    
    boolean existsByNameUser(String nameUser);
    boolean existsByEmail(String email);
}
