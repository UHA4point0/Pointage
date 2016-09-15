package fr.uha40.Dao;

import fr.uha40.Entity.PromEntity;

import java.util.List;

/**
 * PromDao
 * Package : fr.uha40.Dao
 * Created : 14/09/2016 14:20
 * Creator : Mathieu Geissler <mathieu.geissler@cgi.com>.
 */
public interface PromDao {

    List<PromEntity> getAllProms();

    PromEntity getPromById(long id);

    void createProm(PromEntity promEntity);

    void updateProm(PromEntity promEntity);

    void deletePromById(long id);
}
