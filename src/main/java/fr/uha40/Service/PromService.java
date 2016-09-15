package fr.uha40.Service;

import fr.uha40.Entity.PromEntity;

import java.util.List;

/**
 * PromService
 * Package : fr.uha40.Service
 * Created : 14/09/2016 14:19
 * Creator : Mathieu Geissler <mathieu.geissler@cgi.com>.
 */
public interface PromService {

    List<PromEntity> getAllProms();

    void createProm(PromEntity promEntity);

    void updateProm(PromEntity promEntity);

    void deletePromById(long id);
}
