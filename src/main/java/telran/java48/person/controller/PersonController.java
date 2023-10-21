package telran.java48.person.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import telran.java48.person.dto.AddressDto;
import telran.java48.person.dto.CityPopulationDto;
import telran.java48.person.dto.PersonDTO;
import telran.java48.person.service.PersonService;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

	final PersonService personService;

	@PostMapping
	public Boolean addPerson(@RequestBody PersonDTO personDto) {
		return personService.addPerson(personDto);
	}

	@GetMapping("/{id}")
	public PersonDTO findPersonById(@PathVariable Integer id) {
		return personService.findPersonById(id);
	}

	@DeleteMapping("/{id}")
	PersonDTO removePerson(@PathVariable Integer id) {
		return personService.removePerson(id);
	}

	@PutMapping("/{id}/name/{name}")
	PersonDTO updatePersonName(@PathVariable Integer id, @PathVariable String name) {
		return personService.updatePersonName(id, name);
	}

	@PutMapping("/{id}/address")
	PersonDTO updatePersonAddress(@PathVariable Integer id, @RequestBody AddressDto addressDto) {
		return personService.updatePersonAddress(id, addressDto);
	}

	@GetMapping("/city/{city}")
	Iterable<PersonDTO> findPersonsByCity(@PathVariable String city) {
		return personService.findPersonsByCity(city);
	}

	@GetMapping("/name/{name}")
	Iterable<PersonDTO> findPersonsByName(@PathVariable String name) {
		return personService.findPersonsByName(name);
	}

	@GetMapping("/ages/{minAge}/{maxAge}")
	Iterable<PersonDTO> findPersonsBetweenAge(@PathVariable Integer minAge, @PathVariable Integer maxAge) {
		return personService.findPersonsBetwenAge(minAge, maxAge);
	}

	@GetMapping("/population/city")
	Iterable<CityPopulationDto> getCitiesPopulation() {
		return personService.getCitiesPopulation();
	}

}