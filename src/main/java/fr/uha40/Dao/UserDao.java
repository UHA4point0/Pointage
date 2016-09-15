package fr.uha40.Dao;

import fr.uha40.Entity.UserEntity;
import fr.uha40.Exception.NoUserFoundException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * UserDao
 * Package : fr.uha40.Dao
 * Created : 13/09/2016 07:55
 * Creator : Mathieu Geissler <mathieu.geissler@cgi.com>.
 */
@Repository
public interface UserDao {

    UserEntity findByUsername(String username) throws NoUserFoundException;

    UserEntity findById(long id) throws NoUserFoundException;

    List<UserEntity> getAllUsers();

    void addUser(UserEntity userEntity);

    void updateUser(UserEntity userEntity);

    void deleteUserById(long id) throws NoUserFoundException;
}
