package com.example.teretana.repository;

import com.example.teretana.model.Odrzavanje_treninga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OdrzavanjeTreningaRepository extends JpaRepository<Odrzavanje_treninga, Long> {

  // List<Odrzavanje_treninga> findByFitnesId(Long id);

}
