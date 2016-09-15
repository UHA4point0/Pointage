package fr.uha40.Security.model;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * JwtAuthenticationToken
 * Package : fr.uha40.Security
 * Created : 13/09/2016 12:26
 * Creator : Mathieu Geissler <mathieu.geissler@cgi.com>.
 */
public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {


    private String token;

    public JwtAuthenticationToken(String authToken) {
        super(null, null);
        this.token = authToken;

    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }
}
