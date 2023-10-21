package telran.java48.person.service;

import javax.transaction.Transactional;

import org.apache.tomcat.jni.Address;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import telran.java48.person.dao.PersonRepository;
import telran.java48.person.dto.AddressDto;
import telran.java48.person.dto.CityPopulationDto;
import telran.java48.person.dto.PersonDTO;
import telran.java48.person.dto.exeption.PersonNotFoundExeption;
import telran.java48.person.model.Person;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

	final PersonRepository personRepository;
	final ModelMapper modelMapper;

	@Override
	@org.springframework.transaction.annotation.Transactional
	public Boolean addPerson(PersonDTO personDto) {
		if (personRepository.existsById(personDto.getId())) {
			return false;
		}
		personRepository.save(modelMapper.map(personDto, Person.class));
		return true;
	}

	@Override
	public PersonDTO findPersonById(Integer id) {
		Person person = personRepository.findById(id).orElseThrow(PersonNotFoundExeption::new);
		return modelMapper.map(person, PersonDTO.class);
	}

	@Override
	@org.springframework.transaction.annotation.Transactional
	public PersonDTO removePerson(Integer id) {
		Person person = personRepository.findById(id).orElseThrow(PersonNotFoundExeption::new);
		//personRepository.delete(person);
		return modelMapper.map(person, PersonDTO.class);
	}

	@Override
	@org.springframework.transaction.annotation.Transactional
	public PersonDTO updatePersonName(Integer id, String name) {
		Person person = personRepository.findById(id).orElseThrow(PersonNotFoundExeption::new);
		person.setName(name);
		//personRepository.save(person);
		return modelMapper.map(person, PersonDTO.class);
	}

	@Override
	@org.springframework.transaction.annotation.Transactional
	public PersonDTO updatePersonAddress(Integer id, AddressDto addressDto) {
		Person person = personRepository.findById(id).orElseThrow(PersonNotFoundExeption::new);
		person.setAddress(modelMapper.map(addressDto, telran.java48.person.model.Address.class));
		return modelMapper.map(person, PersonDTO.class);
	}

	@Override
	public Iterable<PersonDTO> findPersonsByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<PersonDTO> findPersonsByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<PersonDTO> findPersonsBetwenAge(Integer minAge, Integer maxAge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<CityPopulationDto> getCitiesPopulation() {
		// TODO Auto-generated method stub
		return null;
	}

}