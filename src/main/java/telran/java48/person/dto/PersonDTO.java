package telran.java48.person.dto;

import java.time.LocalDate;

import org.apache.tomcat.jni.Address;

import lombok.Getter;

@Getter
public class PersonDTO {
	Integer id;
	String name;
	LocalDate birthDate;
	AddressDto address;

}
