package fr.uha40.Service;

import fr.uha40.Entity.LevelEntity;

import java.util.List;

/**
 * LevelService
 * Package : fr.uha40.Service
 * Created : 14/09/2016 13:09
 * Creator : Mathieu Geissler <mathieu.geissler@cgi.com>.
 */
public interface LevelService {

    List<LevelEntity> getAllLevels();

    void createLevel(LevelEntity levelEntity);

    void updateLevel(LevelEntity levelEntity);

    void deleteLevel(long id);
}
