package truespot.webapp.Security.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import truespot.consumer.implement.UserRepository;
import truespot.model.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String pseudo) throws UsernameNotFoundException {

        User user = userRepository.findByPseudo(pseudo);
        if (user == null) {
            throw new UsernameNotFoundException("wrong username or password");
        }

        return UserPrinciple.build(user);
    }
}