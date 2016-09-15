package fr.uha40.Dao.impl;

import fr.uha40.Dao.LevelDao;
import fr.uha40.Entity.LevelEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * LevelDaoImpl
 * Package : fr.uha40.Dao.impl
 * Created : 14/09/2016 13:11
 * Creator : Mathieu Geissler <mathieu.geissler@cgi.com>.
 */
@Repository
public class LevelDaoImpl implements LevelDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<LevelEntity> getAllLevels() {
        return em.createQuery("SELECT u from LevelEntity u", LevelEntity.class).getResultList();
    }

    @Override
    public void createLevel(LevelEntity levelEntity) {
        em.persist(levelEntity);
    }

    @Override
    public void updateLevel(LevelEntity levelEntity) {
        em.merge(levelEntity);
    }

    @Override
    public LevelEntity findLevelById(long id) {
        return em.find(LevelEntity.class, id);
    }

    @Override
    public void deleteLevel(long id) {
        LevelEntity levelEntity = this.findLevelById(id);
        em.remove(levelEntity);
    }

}
