package telran.java48.person.dto.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotFoundExeption extends RuntimeException{

	private static final long serialVersionUID = 1874378049529661795L;

}
