package truespot.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import truespot.business.contract.UserMessageManager;
import truespot.model.UserMessage;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserMessageController {

    @Autowired
    UserMessageManager userMessageManager;

    @GetMapping(value="/topo/userMessageByTopo")
    public List<UserMessage> getUserMessagedTopos(Long idTopo){
        return userMessageManager.findAllUserMessageByTopoID(idTopo);
    }

    @RequestMapping(value = "/topo/userMessage", method = RequestMethod.GET)
    public UserMessage getUserMessage(@RequestParam(name = "id", defaultValue = "") String id) {
        return userMessageManager.getUserMessage(Long.valueOf(id));
    }

    @RequestMapping(value = "/topo/userMessage", method = RequestMethod.POST)
    public UserMessage createUserMessage(@RequestBody UserMessage userMessage) {
        return userMessageManager.saveUserMessage(userMessage);
    }

    @PutMapping(value = "/topo/userMessage/{id}")
    public void updateUserMessage(@PathVariable Long id , @RequestBody UserMessage userMessage) {
        userMessageManager.updateUserMessage(id,userMessage);
    }

    @DeleteMapping(value= "/topo/userMessage/{id}")
    public void deleteUserMessage(@PathVariable Long id){
        userMessageManager.deleteUserMessage(id);
    }
}
