package com.portfolio.fontana.Repository;

import com.portfolio.fontana.Entity.People;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPeopleRepository extends JpaRepository<People, Integer> {
    public Optional<People> findByName(String name);
    public boolean existsByName(String name);
}
