package fr.uha40.Security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * JwtTokenMalformedException
 * Package : fr.uha40.Security.exception
 * Created : 13/09/2016 12:47
 * Creator : Mathieu Geissler <mathieu.geissler@cgi.com>.
 */
public class JwtTokenMalformedException extends AuthenticationException {
    public JwtTokenMalformedException(String s) {
        super(s);
    }
}
