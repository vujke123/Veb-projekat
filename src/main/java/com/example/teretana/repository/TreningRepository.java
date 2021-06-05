package com.example.teretana.repository;

import com.example.teretana.model.Trening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreningRepository extends JpaRepository<Trening,Long> {

    @Query("select tr from Trening tr where ((tr.naziv like :naziv ) or (:naziv is null))")
    List<Trening> findAllBySearch(String naziv);
   /* @Modifying
    @Query("update Trening set ocena = :ocena WHERE id = : Id")
    void setRating(@Param("Id") Long id, @Param("ocena") double ocena);*/

}
