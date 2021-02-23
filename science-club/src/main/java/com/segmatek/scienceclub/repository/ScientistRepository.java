package com.segmatek.scienceclub.repository;

import com.segmatek.scienceclub.model.Scientist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScientistRepository extends JpaRepository<Scientist, Long> {
    boolean existsByName(String name);
}
