package ir.ac.sbu.hodhod.hodhod.services;

import ir.ac.sbu.hodhod.hodhod.models.User;
import ir.ac.sbu.hodhod.hodhod.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;


public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findByEmail(username).
                ifPresentOrElse(
                        UserDetailsImpl::new,
                        () -> {
                            throw new UsernameNotFoundException(username)
                        }
                );
//        return findByEmail(username).ifPresent().;
//        findByEmail(username).map(UserDetailsImpl::new)
//                .orElseThrow(throw new UsernameNotFoundException(username));
    }
}
