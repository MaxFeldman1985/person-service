package telran.java48.person.service;

import telran.java48.person.dto.AddressDto;
import telran.java48.person.dto.CityPopulationDto;
import telran.java48.person.dto.PersonDTO;

public interface PersonService {
	Boolean addPerson(PersonDTO personDTO);
	
	PersonDTO findPersonById(Integer Id);
	
	PersonDTO removePerson(Integer id);
	
	PersonDTO updatePersonName(Integer id, String name);
	
	PersonDTO updatePersonAddress(Integer id, AddressDto addressDto);
	
	Iterable<PersonDTO> findPersonsByCity(String city);
	
	Iterable<PersonDTO> findPersonsByName(String name);
	
	Iterable<PersonDTO> findPersonsBetwenAge(Integer minAge,Integer maxAge);
	
	Iterable<CityPopulationDto> getCitiesPopulation();
}
