package fr.uha40.Dao.impl;

import fr.uha40.Dao.UserDao;
import fr.uha40.Entity.UserEntity;
import fr.uha40.Exception.NoUserFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * UserDaoImpl
 * Package : fr.uha40.Dao.impl
 * Created : 13/09/2016 16:05
 * Creator : Mathieu Geissler <mathieu.geissler@cgi.com>.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public UserEntity findByUsername(String username) throws NoUserFoundException {
        UserEntity userEntity;
        try {
            userEntity = em.createQuery("SELECT u FROM UserEntity u WHERE u.username=:username", UserEntity.class)
                    .setParameter("username", username)
                    .getSingleResult();
        } catch (NoResultException e) {
            throw new NoUserFoundException("No user founded");
        }

        return userEntity;
    }

    @Override
    public UserEntity findById(long id) throws NoUserFoundException {
        UserEntity userEntity;
        try {
            userEntity = em.find(UserEntity.class, id);
        } catch (NoResultException e) {
            throw new NoUserFoundException("No user founded");
        }
        return userEntity;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return em.createQuery("SELECT u FROM UserEntity u", UserEntity.class)
                .getResultList();
    }

    @Override
    public void addUser(UserEntity userEntity) {
        em.persist(userEntity);
    }

    @Override
    public void updateUser(UserEntity userEntity) {
        em.merge(userEntity);
    }

    @Override
    public void deleteUserById(long id) throws NoUserFoundException {
        UserEntity user = this.findById(id);
        em.remove(user);
    }

}
