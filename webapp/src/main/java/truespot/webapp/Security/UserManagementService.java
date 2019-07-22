package truespot.webapp.Security;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import truespot.consumer.implement.UserRepository;
import truespot.model.User;



import static java.util.Collections.emptyList;

@Service
public class UserManagementService implements UserDetailsService {

    UserRepository userRepository;

    public UserManagementService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByPseudo(username);
        if (user == null) {
            throw new UsernameNotFoundException("wrong username or password");
        }
        return new org.springframework.security.core.userdetails.User(user.getPseudo(),user.getPassword(),emptyList());
    }
}