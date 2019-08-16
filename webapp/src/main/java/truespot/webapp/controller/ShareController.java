package truespot.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import truespot.business.contract.ShareManager;
import truespot.business.dto.ShareDTO;
import truespot.model.Share;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ShareController {

    @Autowired
    ShareManager shareManager;

    @GetMapping(value="/topo/shareTopos")
    public List<Share> getSharedTopos(){
        return shareManager.findAllShare();
    }

    @RequestMapping(value = "/topo/share/{id}", method = RequestMethod.GET)
    public Share getSharedTopo(@RequestParam(name = "id", defaultValue = "") String id) {
        return shareManager.getShare(new Long(id));
    }

    @RequestMapping(value = "/topo/share", method = RequestMethod.POST)
    public Share createShare(@RequestBody ShareDTO shareDTO) {
        return shareManager.saveShare(shareDTO);
    }

    @PutMapping(value = "/topo/share/{id}")
    public void updateShare(@PathVariable Long id , @RequestBody Share share) {
        shareManager.updateShare(id,share);
    }

    @DeleteMapping(value= "/topo/share/{id}")
    public void deleteShare(@PathVariable Long id){
        shareManager.deleteShare(id);
    }
}
