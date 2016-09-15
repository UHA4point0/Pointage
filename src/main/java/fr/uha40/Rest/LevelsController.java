package fr.uha40.Rest;

import fr.uha40.Entity.LevelEntity;
import fr.uha40.Service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * LevelsController
 * Package : fr.uha40.Rest
 * Created : 14/09/2016 13:08
 * Creator : Mathieu Geissler <mathieu.geissler@cgi.com>.
 */
@RestController
@RequestMapping(value = "/levels")
public class LevelsController {

    @Autowired
    private LevelService levelService;

    @RequestMapping(method = RequestMethod.GET)
    @Secured("USER")
    public List<LevelEntity> getAllLevels() {
        return levelService.getAllLevels();
    }

    @RequestMapping(method = RequestMethod.POST)
    @Secured("ADMIN")
    public LevelEntity createLevel(@RequestBody LevelEntity levelEntity) {
        levelService.createLevel(levelEntity);
        return levelEntity;
    }

    @RequestMapping(method = RequestMethod.PUT)
    @Secured("ADMIN")
    public HttpStatus updateLevel(@RequestBody LevelEntity levelEntity) {
        levelService.updateLevel(levelEntity);
        return HttpStatus.OK;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @Secured("ADMIN")
    public HttpStatus deleteLevel(@PathVariable("id") long id) {
        levelService.deleteLevel(id);
        return HttpStatus.OK;
    }

}
