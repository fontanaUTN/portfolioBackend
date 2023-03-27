package com.portfolio.fontana.Repository;

import com.portfolio.fontana.Entity.About;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RAbout extends JpaRepository<About, Integer>{
    public Optional<About> findByText(String text);
    public boolean existsByText(String text);
}
