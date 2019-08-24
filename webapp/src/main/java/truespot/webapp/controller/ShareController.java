package truespot.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import truespot.business.contract.ShareManager;
import truespot.business.dto.ShareDTO;
import truespot.model.Share;
import truespot.model.Topo;

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

    @RequestMapping(value = "/topo/share", method = RequestMethod.GET)
    public Share getSharedTopo(@RequestParam(name = "id", defaultValue = "") String id) {
        return shareManager.getShare(Long.valueOf(id));
    }

    @RequestMapping(value = "/topo/share/create", method = RequestMethod.POST)
    public Share createShare(@RequestBody ShareDTO shareDTO) {
        return shareManager.saveShare(shareDTO);
    }

    @PutMapping(value = "/topo/share/update")
    public void updateShare(@RequestBody Topo topo) {
        shareManager.updateShare(topo);
    }

    @RequestMapping(value = "/topo/share/delete", method = RequestMethod.PUT)
    public void deleteShare(@RequestParam(name = "id", defaultValue = "")  String id){
        shareManager.deleteShare(Long.valueOf(id));
    }
}
