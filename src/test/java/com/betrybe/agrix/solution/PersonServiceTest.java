package com.betrybe.agrix.solution;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.betrybe.agrix.ebytr.staff.exception.PersonNotFoundException;
import com.betrybe.agrix.ebytr.staff.repository.PersonRepository;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import com.betrybe.agrix.ebytr.staff.entity.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.Optional;

@SpringBootTest
public class PersonServiceTest {

  @MockBean
  private PersonRepository personRepository;

  @Autowired
  private PersonService personService;

  @Test
  @DisplayName("Deve retornar uma pessoa pelo ID(service)")
  public void shouldReturnPersonById() {
    Person mockPerson = new Person();
    mockPerson.setId(1L);
    mockPerson.setUsername("Jonathan");
    mockPerson.setPassword("123456");
    Mockito.when(personRepository.findById(1L)).thenReturn(Optional.of(mockPerson));
    Person foundPerson = personService.getPersonById(1L);
    assertNotNull(foundPerson, "A pessoa encontrada não deve ser nula");
    assertEquals(mockPerson.getId(), foundPerson.getId(), "Os IDs devem ser iguais");
  }

  @Test
  @DisplayName("Deve lançar exceção para pessoa não encontrada pelo ID(service)")
  public void shouldThrowExceptionWhenPersonByIdNotFound() {
    Mockito.when(personRepository.findById(1L)).thenReturn(Optional.empty());
    assertThrows(PersonNotFoundException.class, () -> personService.getPersonById(1L), "Deve lançar uma PersonNotFoundException");
  }

  @Test
  @DisplayName("Deve retornar uma pessoa pelo username(service)")
  public void shouldReturnPersonByUsername() {
    Person mockPerson = new Person();
    mockPerson.setId(1L);
    mockPerson.setUsername("Jonathan");
    mockPerson.setPassword("123456");
    Mockito.when(personRepository.findByUsername("Jonathan")).thenReturn(Optional.of(mockPerson));
    Person foundPerson = personService.getPersonByUsername("Jonathan");
    assertNotNull(foundPerson, "A pessoa encontrada não deve ser nula");
    assertEquals("Jonathan", foundPerson.getUsername(), "Os usernames devem ser iguais");
  }

  @Test
  @DisplayName("Deve lançar exceção para pessoa não encontrada pelo username(service)")
  public void shouldThrowExceptionWhenPersonByUsernameNotFound() {
    Mockito.when(personRepository.findByUsername("Jonathan")).thenReturn(Optional.empty());
    assertThrows(PersonNotFoundException.class, () -> personService.getPersonByUsername("Jonathan"), "Deve lançar uma PersonNotFoundException");
  }

  @Test
  @DisplayName("Deve criar uma nova pessoa(service)")
  public void shouldCreatePerson() {
    Person newPerson = new Person();
    newPerson.setUsername("NovoJonathan");
    newPerson.setPassword("654321");
    Mockito.when(personRepository.save(Mockito.any(Person.class))).thenReturn(newPerson);
    Person createdPerson = personService.create(newPerson);
    assertNotNull(createdPerson, "A pessoa criada não deve ser nula");
    assertEquals("NovoJonathan", createdPerson.getUsername(), "Os usernames devem ser iguais após a criação");
  }


}
