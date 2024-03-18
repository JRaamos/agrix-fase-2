package com.betrybe.agrix.controllers;

import static com.betrybe.agrix.util.CropsUtil.cropResponseconvert;

import com.betrybe.agrix.dtos.CropsResponse;
import com.betrybe.agrix.models.entities.Crops;
import com.betrybe.agrix.service.CropsService;
import com.betrybe.agrix.util.CropsUtil;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  CropsController com resposta para o cliente.
 */
@RestController
@RequestMapping("/crops")
public class CropsController {
  @Autowired
  private CropsService cropsService;

  /**
   * Metodo para buscar.
   */
  @GetMapping
public List<CropsResponse> getAllCrops() {
    return cropsService.findAllCrops().stream()
        .map(CropsUtil::cropResponseconvert)
        .collect(Collectors.toList());
  }

  /**
   * Metodo para buscar Crops por parametro especifico.
   */
  @GetMapping("/{id}")
  public ResponseEntity<?> getCropsById(@PathVariable Long id) {
    Crops crops = cropsService.findCropById(id);
    return ResponseEntity.status(HttpStatus.OK).body(cropResponseconvert(crops));
  }
}
