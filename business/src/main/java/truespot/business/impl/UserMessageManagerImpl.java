package truespot.business.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import truespot.business.contract.UserMessageManager;
import truespot.consumer.implement.UserMessageRepository;
import truespot.model.UserMessage;

import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class UserMessageManagerImpl extends BusinessManagerImpl implements UserMessageManager {


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
        return getDaoFactory().getUserMessageRepository().save(userMessage);
    }

    @Override
    public void updateUserMessage(Long id, UserMessage userMessage) {
        getDaoFactory().getUserMessageRepository().save(userMessage);
    }

    @Override
    public void deleteUserMessage(Long id) {
        getDaoFactory().getUserMessageRepository().deleteById(id);
    }
}
