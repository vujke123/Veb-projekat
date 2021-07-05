package com.example.teretana.repository;

import com.example.teretana.model.Korisnik;
import com.example.teretana.model.Uloga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik,Long> {

    Korisnik findByEmail(String email);

    List<Korisnik> findByUloga(Uloga uloga);

}
