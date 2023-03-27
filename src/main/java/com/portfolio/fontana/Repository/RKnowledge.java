package com.portfolio.fontana.Repository;

import com.portfolio.fontana.Entity.Knowledge;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RKnowledge extends JpaRepository<Knowledge, Integer>{
    public Optional<Knowledge> findByNameK(String nameK);
    public boolean existsByNameK(String nameK);
}
