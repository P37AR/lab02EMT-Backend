package mk.ukim.finki.labs.lab02emt.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoBooksLeftException extends RuntimeException{

    public NoBooksLeftException() {}
}
