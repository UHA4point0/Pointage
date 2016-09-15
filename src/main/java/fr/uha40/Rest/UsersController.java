package fr.uha40.Rest;

import fr.uha40.Entity.UserEntity;
import fr.uha40.Exception.NoUserFoundException;
import fr.uha40.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

/**
 * UserController
 * Package : fr.uha40.Rest
 * Created : 13/09/2016 07:37
 * Creator : Mathieu Geissler <mathieu.geissler@cgi.com>.
 */
@RestController
@RequestMapping(value = "/users")
public class UsersController {

    @Inject
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    @Secured("ADMIN")
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.POST)
    public UserEntity addUser(@RequestBody UserEntity userEntity) {
        userService.addUser(userEntity);
        return userEntity;
    }

    @RequestMapping(method = RequestMethod.PUT)
    @Secured("USER")
    public HttpStatus updateUser(@RequestBody UserEntity userEntity) {
        userService.updateUser(userEntity);
        return HttpStatus.OK;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @Secured("ADMIN")
    public HttpStatus deleteUserById(@PathVariable("id") long id) {
        try {
            userService.deleteUserById(id);
        } catch (NoUserFoundException e) {
            e.printStackTrace();
            return HttpStatus.NOT_FOUND;
        }
        return HttpStatus.OK;
    }
}
