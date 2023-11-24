package webminds.group.pet_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ConflictCreateException extends RuntimeException{

    public ConflictCreateException(String entity, String value) {
        super(String.format("There is already a registered %s in the %s field.", value, entity));
    }
}
