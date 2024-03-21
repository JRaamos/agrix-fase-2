package com.betrybe.agrix.service;

import com.betrybe.agrix.models.entities.Fertilizers;
import com.betrybe.agrix.models.repositories.FertilizerRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  Service Fertilizers.
 */
@Service
public class FertilizersService {

  private final FertilizerRepositorie fertilizerRepositorie;

  @Autowired
  public FertilizersService(FertilizerRepositorie fertilizerRepositorie) {
    this.fertilizerRepositorie = fertilizerRepositorie;
  }

  public Fertilizers createFertilizer(Fertilizers fertilizer) {
    return fertilizerRepositorie.save(fertilizer);
  }
}
