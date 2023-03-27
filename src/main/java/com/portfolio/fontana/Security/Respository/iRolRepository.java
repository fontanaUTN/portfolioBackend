package com.portfolio.fontana.Security.Respository;

import com.portfolio.fontana.Security.Entity.Rol;
import com.portfolio.fontana.Security.Enums.RolName;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolName (RolName rolName);
}
