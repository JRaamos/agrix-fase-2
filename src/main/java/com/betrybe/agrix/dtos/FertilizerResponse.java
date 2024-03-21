package com.betrybe.agrix.dtos;

/**
 * Fertilizer DTO for responses.
 */
public record FertilizerResponse(Long id, String name, String brand, String composition) {
}
