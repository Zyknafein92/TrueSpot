package truespot.business.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import truespot.business.contract.UserMessageManager;
import truespot.consumer.implement.UserMessageRepository;
import truespot.model.UserMessage;

import java.util.Date;
import java.util.List;

@Service
public class UserMessageManagerImpl extends BusinessManagerImpl implements UserMessageManager {

    @Autowired
    UserMessageRepository userMessageRepository;


    @Override
    public List<UserMessage> findAllUserMessageByTopoID(Long id) {
        return getDaoFactory().getUserMessageRepository().findAllUserMessageByTopoID(id);
    }

    @Override
    public UserMessage getUserMessage(Long id) {
        return getDaoFactory().getUserMessageRepository().getOne(id);
    }

    @Override
    public UserMessage saveUserMessage(UserMessage userMessage) {
        userMessage.setDate(new Date());
       return getDaoFactory().getUserMessageRepository().save(userMessage);
    }

    @Override
    public void updateUserMessage(UserMessage userMessage) {
        getDaoFactory().getUserMessageRepository().save(userMessage);
    }

    @Override
    public void deleteUserMessage(Long id) {
        getDaoFactory().getUserMessageRepository().delete(getDaoFactory().getUserMessageRepository().getOne(id));
    }
}
