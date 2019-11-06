package clubgroup.clubdemo;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class clubException extends RuntimeException {

    public clubException() {
        super();
    }

    public clubException(String message) {
        super(message);
    }

    public clubException(String message, Throwable cause) {
        super(message, cause);
    }
}
