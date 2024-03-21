package com.betrybe.agrix.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.Set;

/**
 *  entidade de Fertilizers.
 */
@Entity
@Table(name = "fertilizers")
public class Fertilizers {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String brand;
  private String composition;

  @ManyToMany
  @JoinTable(
      name = "crops_fertilizers",
      joinColumns = @JoinColumn(name = "fertilizer_id"),
      inverseJoinColumns = @JoinColumn(name = "crops_id")
  )
  private Set<Crops> crops;
  public Long getId() { return id; }

  public String getName() { return name; }

  public String getBrand() { return brand; }

  public String getComposition() { return composition; }

  public void setId(Long id) { this.id = id; }

  public void setName(String name) { this.name = name; }

  public void setBrand(String brand) { this.brand = brand; }

  public void setComposition(String composition) {
    this.composition = composition;
  }

}
