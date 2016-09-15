package fr.uha40.Dao;

import fr.uha40.Entity.LevelEntity;

import java.util.List;

/**
 * LevelDao
 * Package : fr.uha40.Dao
 * Created : 14/09/2016 13:11
 * Creator : Mathieu Geissler <mathieu.geissler@cgi.com>.
 */
public interface LevelDao {

    List<LevelEntity> getAllLevels();

    void createLevel(LevelEntity levelEntity);

    void updateLevel(LevelEntity levelEntity);

    LevelEntity findLevelById(long id);

    void deleteLevel(long id);
}
