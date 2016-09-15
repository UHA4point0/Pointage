package fr.uha40.Service.impl;

import fr.uha40.Dao.PromDao;
import fr.uha40.Entity.PromEntity;
import fr.uha40.Service.PromService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * PromServiceImpl
 * Package : fr.uha40.Service.impl
 * Created : 14/09/2016 14:19
 * Creator : Mathieu Geissler <mathieu.geissler@cgi.com>.
 */
@Service
@Transactional
public class PromServiceImpl implements PromService {

    @Autowired
    private PromDao promDao;

    @Override
    public List<PromEntity> getAllProms() {
        return promDao.getAllProms();
    }

    @Override
    public void createProm(PromEntity promEntity) {
        promDao.createProm(promEntity);
    }

    @Override
    public void updateProm(PromEntity promEntity) {
        promDao.updateProm(promEntity);
    }

    @Override
    public void deletePromById(long id) {
        promDao.deletePromById(id);
    }

}
