package com.betrybe.agrix.dtos;

/**
 * Crops dto Response.
 */
public record CropsResponse(Long id, String name, Double plantedArea, Long farmId) {
}
