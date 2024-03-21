package com.betrybe.agrix.util;

import com.betrybe.agrix.dtos.FertilizersRequest;
import com.betrybe.agrix.dtos.FertilizerResponse;
import com.betrybe.agrix.models.entities.Fertilizers;

public class FertilizersUtil {

  public static FertilizerResponse fertilizerResponseConvert(Fertilizers fertilizer) {
    return new FertilizerResponse(
        fertilizer.getId(),
        fertilizer.getName(),
        fertilizer.getBrand(),
        fertilizer.getComposition()
    );
  }

  public static Fertilizers fertilizerDtoCreateConvert(FertilizersRequest request) {
    Fertilizers fertilizer = new Fertilizers();
    fertilizer.setName(request.name());
    fertilizer.setBrand(request.brand());
    fertilizer.setComposition(request.composition());
    return fertilizer;
  }
}
