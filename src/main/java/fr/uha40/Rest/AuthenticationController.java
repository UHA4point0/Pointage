package fr.uha40.Rest;

import fr.uha40.Exception.NoUserFoundException;
import fr.uha40.Security.dto.JwtUserDto;
import fr.uha40.Security.exception.NoMatchingPassword;
import fr.uha40.Security.model.JwtAuthenticationToken;
import fr.uha40.Security.utils.JwtTokenUtils;
import fr.uha40.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * AuthenticationController
 * Package : fr.uha40.Rest
 * Created : 13/09/2016 13:19
 * Creator : Mathieu Geissler <mathieu.geissler@cgi.com>.
 */
@RestController
@RequestMapping(value = "/auth")
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    @RequestMapping(path = "/login", method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
    public JwtAuthenticationToken authUser(@RequestParam(value = "login") String login, @RequestParam(value = "password") String password) throws NoMatchingPassword, NoUserFoundException {
        try {
            JwtUserDto userDto = userService.checkUserAuth(login, password);
            JwtAuthenticationToken token = jwtTokenUtils.generateToken(userDto);

            return token;
        } catch (NoMatchingPassword | NoUserFoundException e) {
            throw e;
        }
    }

}
