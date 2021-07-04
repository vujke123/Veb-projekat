package com.example.teretana.repository;

import com.example.teretana.model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaRepository extends JpaRepository<Sala,Long> {
    @Modifying
    @Query("update Sala set oznaka_sale = :oznaka, kapacitet=:kapacitet WHERE id = :sobaId")
    void updateRoom(@Param("sobaId") Long id, @Param("kapacitet") int kapacitet, @Param("oznaka") String oznaka);
}
