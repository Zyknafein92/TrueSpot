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

    @GetMapping(value="/topo/sharedTopos")
    public List<Share> getSharedTopos(){
        return shareManager.findAllShare();
    }

    @RequestMapping(value = "/topo/sharedTopo/{id}", method = RequestMethod.GET)
    public ShareDTO getSharedTopo(@RequestParam(name = "id", defaultValue = "") String id) {
        return ShareManager.getShare(new Long(id));
    }

    @RequestMapping(value = "/topo/sharedTopo", method = RequestMethod.POST)
    public Share createShare(@RequestBody ShareDTO shareDTO) {
        return ShareManager.saveShare(shareDTO);
    }

    @PutMapping(value = "/topo/{id}")
    public void updateShare(@PathVariable Long id , @RequestBody Share share) {
        ShareManager.updateShare(id,share);
    }

    @DeleteMapping(value= "/topo/{id}")
    public void deleteShare(@PathVariable Long id){
        ShareManager.deleteShare(id);
    }
}
