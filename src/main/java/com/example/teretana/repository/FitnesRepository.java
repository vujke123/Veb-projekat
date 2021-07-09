package com.example.teretana.repository;

import com.example.teretana.model.Fitnes_Centar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FitnesRepository extends JpaRepository<Fitnes_Centar, Long> {
//    @Query ("update Fitnes_Centar set naziv = :naziv, adresa = : adresa, br_tel_centrale =: br_tel_centrale, email = : email WHERE id = : id")
//    void updateFitnes(@Param("id") Long id, @Param("naziv") String naziv, @Param("adresa") String adresa,@Param("br_tel_centrale") String br_tel_centrale,@Param("email") String email);

    @Query ("delete from Fitnes_Centar f  where f.id =:id ")
    public void delete(Long id);

    public void deleteByNaziv(String naziv);
}

