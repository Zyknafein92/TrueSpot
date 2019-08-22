package truespot.business.contract;

import truespot.model.UserMessage;

import java.util.List;

public interface UserMessageManager {

    List<UserMessage> findAllUserMessageByTopoID(Long id);

    UserMessage getUserMessage(Long id);

    UserMessage saveUserMessage(UserMessage userMessage);

    void updateUserMessage(Long id, UserMessage userMessage);

    void deleteUserMessage(Long id);
}
