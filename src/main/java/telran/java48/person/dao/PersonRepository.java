package telran.java48.person.dao;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import antlr.collections.List;
import telran.java48.person.dto.CityPopulationDto;
import telran.java48.person.model.Person;

public interface PersonRepository extends CrudRepository<Person, Integer>{
	//@Query("select p from Person p where p.name=?1")
	Stream<Person> findByNameIgnorCase(String name);

	//@Query("select p from Person p where p.address.city=cityName")
	Stream<Person> findByAddressCityCase(@Param("cityName") String city);

	Stream<Person> findByBirthDateBetween(LocalDate from, LocalDate to);
	
	@Query("select new telran.java48.person.dto.CityPopulationDto(p.address.city, count(p)) from Person p group by p.address.city order by count(p) asc")
	java.util.List<CityPopulationDto> getCitiesPopulation();

	java.util.List<Person> findAllChildren();

	java.util.List<Person> findEmployeesBySalaryBetween(double minSalary, double maxSalary);

}
