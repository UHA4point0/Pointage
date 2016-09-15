package fr.uha40.Dao.impl;

import fr.uha40.Dao.PromDao;
import fr.uha40.Entity.PromEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * PromDaoImpl
 * Package : fr.uha40.Dao.impl
 * Created : 14/09/2016 14:20
 * Creator : Mathieu Geissler <mathieu.geissler@cgi.com>.
 */
@Repository
public class PromDaoImpl implements PromDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<PromEntity> getAllProms() {
        return em.createQuery("select u from PromEntity u").getResultList();
    }

    @Override
    public PromEntity getPromById(long id) {
        return em.find(PromEntity.class, id);
    }

    @Override
    public void createProm(PromEntity promEntity) {
        em.persist(promEntity);
    }

    @Override
    public void updateProm(PromEntity promEntity) {
        em.merge(promEntity);
    }

    @Override
    public void deletePromById(long id) {
        PromEntity promEntity = this.getPromById(id);
        em.remove(promEntity);
    }

}
