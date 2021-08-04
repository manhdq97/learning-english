package learning.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NoSuchElementFoundException extends ResponseStatusException {

    public NoSuchElementFoundException(HttpStatus status) {
        super(status);
    }

    public NoSuchElementFoundException(HttpStatus status, String reason) {
        super(status, reason);
    }

    public NoSuchElementFoundException(HttpStatus status, String reason, Throwable cause) {
        super(status, reason, cause);
    }

    public NoSuchElementFoundException(int rawStatusCode, String reason, Throwable cause) {
        super(rawStatusCode, reason, cause);
    }
}
