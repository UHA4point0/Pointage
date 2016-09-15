package fr.uha40.Security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * JwtTokenMissingException
 * Package : fr.uha40.Exception
 * Created : 13/09/2016 12:04
 * Creator : Mathieu Geissler <mathieu.geissler@cgi.com>.
 */
public class JwtTokenMissingException extends AuthenticationException {
    public JwtTokenMissingException(String s) {
        super(s);
    }
}
