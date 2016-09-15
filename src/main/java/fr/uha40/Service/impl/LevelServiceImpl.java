package fr.uha40.Service.impl;

import fr.uha40.Dao.LevelDao;
import fr.uha40.Entity.LevelEntity;
import fr.uha40.Service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * LevelServiceImpl
 * Package : fr.uha40.Service.impl
 * Created : 14/09/2016 13:09
 * Creator : Mathieu Geissler <mathieu.geissler@cgi.com>.
 */
@Service
@Transactional
public class LevelServiceImpl implements LevelService {

    @Autowired
    private LevelDao levelDao;

    @Override
    public List<LevelEntity> getAllLevels() {
        return levelDao.getAllLevels();
    }

    @Override
    public void createLevel(LevelEntity levelEntity) {
        levelDao.createLevel(levelEntity);
    }

    @Override
    public void updateLevel(LevelEntity levelEntity) {
        levelDao.updateLevel(levelEntity);
    }

    @Override
    public void deleteLevel(long id) {
        levelDao.deleteLevel(id);
    }
}
