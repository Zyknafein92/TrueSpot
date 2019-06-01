package truespot.webapp.Security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import truespot.consumer.implement.UserRepository;
import truespot.model.User;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class UserManagementService implements UserDetailsService {

    UserRepository userRepository;

    public UserManagementService( UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByPseudo(username);
        if (user == null) {
            throw new UsernameNotFoundException("wrong username or password");
        }
        //todo revoir cette partie
        return new org.springframework.security.core.userdetails.User(user.getPseudo(), user.getPassword(),
                username.equals("macdo") ? Arrays.asList(new SimpleGrantedAuthority("ADMIN")) : new ArrayList<>());
    }
}
