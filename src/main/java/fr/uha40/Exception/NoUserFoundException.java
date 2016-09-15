package fr.uha40.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * NoUserFoundException
 * Package : fr.uha40.Exception
 * Created : 14/09/2016 07:32
 * Creator : Mathieu Geissler <mathieu.geissler@cgi.com>.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoUserFoundException extends Exception {

    public NoUserFoundException(String message) {
        super(message);
    }
}
