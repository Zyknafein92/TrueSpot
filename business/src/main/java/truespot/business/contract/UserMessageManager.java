package truespot.business.contract;

import truespot.business.dto.UserMessageDTO;
import truespot.model.UserMessage;

import java.util.List;

public interface UserMessageManager {

    List<UserMessage> findAllUserMessageByTopoID(Long id);

    UserMessage getUserMessage(Long id);

    UserMessage saveUserMessage(UserMessage userMessage);

    void updateUserMessage(UserMessage userMessage);

    void deleteUserMessage(Long id);
}
