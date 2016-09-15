package fr.uha40.Security.utils;

import fr.uha40.Enums.Role;
import fr.uha40.Security.dto.JwtUserDto;
import fr.uha40.Security.model.JwtAuthenticationToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

/**
 * JwtTokenValidator
 * Package : fr.uha40.Security.utils
 * Created : 13/09/2016 12:38
 * Creator : Mathieu Geissler <mathieu.geissler@cgi.com>.
 */
@Component
public class JwtTokenUtils {

    @Value("${pointage.token.secret")
    private String secret;

    public JwtUserDto parseToken(String token) {
        JwtUserDto u = null;

        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
            u = new JwtUserDto();
            u.setUsername(body.getSubject());
            u.setId(Long.parseLong((String) body.get("userId")));
            u.setRole(Role.valueOf((String) body.get("role")));
        } catch (JwtException e) {
            // Simply print the exception and null will be returned for the userDto
            e.printStackTrace();
        }
        return u;
    }

    public JwtAuthenticationToken generateToken(JwtUserDto userDto) {
        Date currentTime = new Date();

        // TODO : Expiration Date

        Calendar cal = Calendar.getInstance();

        cal.setTime(currentTime);
        cal.add(Calendar.MINUTE, -1);
        Date notBefore = cal.getTime();

        Claims claims = Jwts.claims().setSubject(userDto.getUsername()).setNotBefore(notBefore).setIssuedAt(currentTime);
        claims.put("userId", userDto.getId() + "");
        claims.put("role", userDto.getRole());

        String token = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, secret).compact();

        return new JwtAuthenticationToken(token);
    }
}
