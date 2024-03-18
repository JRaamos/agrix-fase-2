package com.betrybe.agrix.advice;

import com.betrybe.agrix.exeptions.CropsException;
import com.betrybe.agrix.exeptions.FarmsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *  Metodo para controle de erro.
 */
@ControllerAdvice
public class ControllerException {
  @ExceptionHandler(FarmsException.class)
  public ResponseEntity<String> handleFarmNotFoundException(FarmsException e) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fazenda não encontrada!");
  }

  @ExceptionHandler(CropsException.class)
  public ResponseEntity<String> handleCropNotFoundException(CropsException e) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Plantação não encontrada!");
  }
}
