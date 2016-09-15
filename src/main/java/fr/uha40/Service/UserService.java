package fr.uha40.Service;

import fr.uha40.Entity.UserEntity;
import fr.uha40.Exception.NoUserFoundException;
import fr.uha40.Security.dto.JwtUserDto;
import fr.uha40.Security.exception.NoMatchingPassword;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

/**
 * UserService
 * Package : fr.uha40.Service
 * Created : 13/09/2016 07:58
 * Creator : Mathieu Geissler <mathieu.geissler@cgi.com>.
 */
public interface UserService {

    UserEntity getUserByUsername(String username) throws NoUserFoundException;

    JwtUserDto checkUserAuth(String username, String password) throws NoMatchingPassword, NoUserFoundException;

    List<UserEntity> getAllUsers();

    void addUser(UserEntity userEntity);

    void updateUser(UserEntity userEntity);

    void deleteUserById(long id) throws NoUserFoundException;
}
