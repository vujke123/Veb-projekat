package com.example.teretana.repository;

import com.example.teretana.model.Trening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TreningRepository extends JpaRepository<Trening,Long> {
   /* @Modifying
    @Query("update Trening set ocena = :ocena WHERE id = : Id")
    void setRating(@Param("Id") Long id, @Param("ocena") double ocena);*/

}
