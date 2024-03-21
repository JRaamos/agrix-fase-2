package com.betrybe.agrix.service;

import com.betrybe.agrix.exeptions.CropsException;
import com.betrybe.agrix.models.entities.Crops;
import com.betrybe.agrix.models.repositories.CropsRepositorie;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service Crops.
 */
@Service
public class CropsService {
  @Autowired
  private CropsRepositorie cropsRepositorie;

  public List<Crops> findAllCrops() {
    return cropsRepositorie.findAll();
  }

  /**
   * Metodo para buscar por id.
   */
  public Crops findCropById(Long id) {
    Optional<Crops> cropsOptional = cropsRepositorie.findById(id);
    if (cropsOptional.isPresent()) {
      return cropsOptional.get();
    }
    throw new CropsException();
  }

  /**
   * Metodo para bucar por data.
   */
  public List<Crops> findCropsBetweenDates(LocalDate start, LocalDate end) {
    return cropsRepositorie.findByHarvestDateBetween(start, end);
  }
}
