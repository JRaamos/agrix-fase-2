package com.betrybe.agrix.models.repositories;

import com.betrybe.agrix.models.entities.Crops;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *  Interface para crops.
 */

@Repository
public interface CropsRepositorie extends JpaRepository<Crops, Long> {
}
