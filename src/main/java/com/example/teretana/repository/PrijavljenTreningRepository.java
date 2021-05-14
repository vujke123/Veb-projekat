package com.example.teretana.repository;

import com.example.teretana.model.Prijavljen_Trening;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrijavljenTreningRepository extends JpaRepository<Prijavljen_Trening, Long> {
    
}
