package com.argprograma.portfolio.repository;

import com.argprograma.portfolio.model.Portfolio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioRepository extends JpaRepository <Portfolio, Long> {
    Portfolio findByName (String name);
}
