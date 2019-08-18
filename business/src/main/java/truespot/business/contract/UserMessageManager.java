package truespot.business.contract;

import java.util.List;

public interface UserMessageManager {

    List<UserMessageManager> findAllUserMessageManager();

    UserMessageManager getUserMessageManager(Long id);

    UserMessageManager saveUserMessageManager(UserMessageManager userMessageManager);

    void updateUserMessageManager(Long id, UserMessageManager userMessageManager);

    void deleteUserMessageManager(Long id);
}
