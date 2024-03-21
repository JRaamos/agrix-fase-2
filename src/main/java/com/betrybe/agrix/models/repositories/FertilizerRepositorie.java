package com.betrybe.agrix.models.repositories;
import com.betrybe.agrix.models.entities.Fertilizers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FertilizerRepositorie extends JpaRepository<Fertilizers, Long> {
}

