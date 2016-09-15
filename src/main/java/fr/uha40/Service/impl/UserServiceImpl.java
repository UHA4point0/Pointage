package fr.uha40.Service.impl;

import com.lambdaworks.crypto.SCryptUtil;
import fr.uha40.Dao.UserDao;
import fr.uha40.Dto.DtoFactory;
import fr.uha40.Entity.UserEntity;
import fr.uha40.Exception.NoUserFoundException;
import fr.uha40.Security.dto.JwtUserDto;
import fr.uha40.Security.exception.NoMatchingPassword;
import fr.uha40.Service.UserService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import java.util.List;

/**
 * UserServiceImpl
 * Package : fr.uha40.Service.impl
 * Created : 13/09/2016 07:59
 * Creator : Mathieu Geissler <mathieu.geissler@cgi.com>.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Inject
    private UserDao userDao;

    @Inject
    private DtoFactory dtoFactory;

    @Override
    public UserEntity getUserByUsername(String username) throws NoUserFoundException {
        return userDao.findByUsername(username);
    }

    @Override
    public JwtUserDto checkUserAuth(String username, String password) throws NoMatchingPassword, NoUserFoundException {
        UserEntity userEntity = this.getUserByUsername(username);

        assert userEntity != null;

        boolean check = BCrypt.checkpw(password, userEntity.getPassword());
        if (!check) {
            throw new NoMatchingPassword();
        }

        JwtUserDto userDto = dtoFactory.createUserDto(userEntity);

        return userDto;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void addUser(UserEntity userEntity) {
        userDao.addUser(userEntity);
    }

    @Override
    public void updateUser(UserEntity userEntity) {
        userDao.updateUser(userEntity);
    }

    @Override
    public void deleteUserById(long id) throws NoUserFoundException {
        userDao.deleteUserById(id);
    }

}
