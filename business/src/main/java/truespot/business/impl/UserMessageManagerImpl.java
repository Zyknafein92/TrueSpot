package truespot.business.impl;


import org.springframework.stereotype.Service;
import truespot.business.contract.UserMessageManager;
import truespot.model.UserMessage;

import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class UserMessageManagerImpl extends BusinessManagerImpl implements UserMessageManager {


    @Override
    public List<UserMessageManager> findAllUserMessageManager() {
        return null;
    }

    @Override
    public UserMessageManager getUserMessageManager(Long id) {
        return null;
    }

    @Override
    public UserMessageManager saveUserMessageManager(UserMessageManager userMessageManager) {
        UserMessage userMessage = new UserMessage();
        userMessage.setDate(new Date(String.valueOf(Locale.FRANCE)));
        return null;
    }

    @Override
    public void updateUserMessageManager(Long id, UserMessageManager userMessageManager) {

    }

    @Override
    public void deleteUserMessageManager(Long id) {

    }
}
