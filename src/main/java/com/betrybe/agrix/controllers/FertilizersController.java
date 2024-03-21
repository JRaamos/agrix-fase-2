package com.betrybe.agrix.controllers;

import com.betrybe.agrix.dtos.FertilizersRequest;
import com.betrybe.agrix.dtos.FertilizersResponse;
import com.betrybe.agrix.models.entities.Fertilizers;
import com.betrybe.agrix.service.FertilizersService;
import com.betrybe.agrix.util.FertilizersUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fertilizers")
public class FertilizersController {
  private final FertilizersService fertilizerService;

  @Autowired
  public FertilizersController(FertilizersService fertilizerService) {
    this.fertilizerService = fertilizerService;
  }

  @PostMapping
  public ResponseEntity<FertilizersResponse> createFertilizer(@RequestBody FertilizersRequest fertilizerRequest) {
    Fertilizers newFertilizer = FertilizersUtil.fertilizerDtoCreateConvert(fertilizerRequest);

    Fertilizers savedFertilizer = fertilizerService.createFertilizer(newFertilizer);
    FertilizersResponse response = FertilizersUtil.fertilizerResponseConvert(savedFertilizer);

    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }
}
