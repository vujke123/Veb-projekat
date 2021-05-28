package com.example.teretana.repository;

import com.example.teretana.model.Odradjen_trening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OdradjenTreningRepository  extends JpaRepository <Odradjen_trening, Long > {

  // List<Odradjen_trening> findByTreningId(Long id);
   // @Modifying
   // @Query("update Odradjen_trening set ocena = :ocena WHERE id = :Id")
   // void setRating(@Param("Id") Long id, @Param("ocena") long ocena);

}
