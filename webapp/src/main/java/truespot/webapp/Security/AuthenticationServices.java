package truespot.webapp.Security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import truespot.business.contract.UserManager;
import truespot.business.impl.BusinessManagerImpl;
import truespot.consumer.contract.DaoFactory;
import truespot.consumer.implement.UserRepository;
import truespot.model.User;

import java.util.Arrays;
import java.util.List;

@Service(value = "userService")
public class AuthenticationServices extends BusinessManagerImpl implements UserDetailsService {




    public AuthenticationServices() {
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User foundUser = getDaoFactory().getUserRepository().findByPseudo(username);

        if (foundUser.getPseudo() == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(foundUser.getPseudo(), foundUser.getPassword(), getAuthority());
    }

    private List<SimpleGrantedAuthority> getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }
}
