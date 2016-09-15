package fr.uha40.Rest;

import fr.uha40.Entity.PromEntity;
import fr.uha40.Service.PromService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * PromsController
 * Package : fr.uha40.Rest
 * Created : 14/09/2016 14:17
 * Creator : Mathieu Geissler <mathieu.geissler@cgi.com>.
 */
@RestController
@RequestMapping(value = "/proms")
public class PromsController {

    @Autowired
    private PromService promService;

    @RequestMapping(method = RequestMethod.GET)
    public List<PromEntity> getAllProms() {
        return promService.getAllProms();
    }

    @RequestMapping(method = RequestMethod.POST)
    public PromEntity createProm(@RequestBody PromEntity promEntity) {
        promService.createProm(promEntity);
        return promEntity;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public HttpStatus updateProm(@RequestBody PromEntity promEntity) {
        promService.updateProm(promEntity);
        return HttpStatus.OK;
    }

    @RequestMapping(path = "/{id}",method = RequestMethod.DELETE)
    public HttpStatus deleteProm(@PathVariable("id") long id) {
        promService.deletePromById(id);
        return HttpStatus.OK;
    }

}
