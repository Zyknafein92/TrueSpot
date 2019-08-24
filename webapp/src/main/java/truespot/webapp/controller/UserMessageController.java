package truespot.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import truespot.business.contract.UserMessageManager;
import truespot.business.dto.UserMessageDTO;
import truespot.model.Share;
import truespot.model.UserMessage;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class UserMessageController {

    @Autowired
    UserMessageManager userMessageManager;


    @RequestMapping(value = "/message/topo/userMessageByTopo", method = RequestMethod.GET)
    public List<UserMessage> getAllUserMessageByTopo(@RequestParam(name = "idTopo", defaultValue = "") String idTopo) {
        return userMessageManager.findAllUserMessageByTopoID(Long.valueOf(idTopo));
    }


    @RequestMapping(value = "/message/topo/userMessage", method = RequestMethod.GET)
    public UserMessage getUserMessage(@RequestParam(name = "id", defaultValue = "") String id) {
        return userMessageManager.getUserMessage(Long.valueOf(id));
    }


    @RequestMapping(value = "/message/topo/userMessage/save", method = RequestMethod.POST)
    public UserMessage createUserMessage(@RequestBody UserMessage userMessage) {

        return userMessageManager.saveUserMessage(userMessage);
    }

    @PutMapping(value = "/message/topo/userMessage/update")
    public void updateUserMessage(@RequestBody UserMessage userMessage) {
        userMessageManager.updateUserMessage(userMessage);
    }

    @DeleteMapping(value= "/message/topo/userMessage/{id}")
    public void deleteUserMessage(@PathVariable Long id){
        userMessageManager.deleteUserMessage(id);
    }
}
