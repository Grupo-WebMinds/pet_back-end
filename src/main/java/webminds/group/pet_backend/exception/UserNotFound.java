package webminds.group.pet_backend.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class UserNotFound extends RuntimeException{

    public UserNotFound(Object object, Long id) {
        super(String.format("%s não foi encontrada com id %s", object, id));
    }
}
