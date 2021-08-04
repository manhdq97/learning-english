package learning.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class MethodArgumentNotValidException extends ResponseStatusException {

    public MethodArgumentNotValidException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
