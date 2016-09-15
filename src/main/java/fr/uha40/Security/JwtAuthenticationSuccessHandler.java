package fr.uha40.Security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * JwtAuthenticationSuccessHandler
 * Package : fr.uha40.Security
 * Created : 13/09/2016 12:33
 * Creator : Mathieu Geissler <mathieu.geissler@cgi.com>.
 */
public class JwtAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        // Defines where to go after successful login
        // Nothing for REST API
    }
}
