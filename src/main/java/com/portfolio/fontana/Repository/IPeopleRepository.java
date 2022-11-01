package com.portfolio.fontana.Repository;

import com.portfolio.fontana.Entity.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPeopleRepository extends JpaRepository<People, Long> {
    
}
