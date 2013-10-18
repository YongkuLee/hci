package kr.ac.korea.mobide.hci.infrastructure.security;

import kr.ac.korea.mobide.hci.domain.model.user.UserRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@Service
@Transactional
public class DefaultUserService implements UserDetailsService {

    private UserRepository userRepository;

    @Inject
    public DefaultUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException, DataAccessException {
        kr.ac.korea.mobide.hci.domain.model.user.User user = userRepository
                .findByEmail(email);

        User detail = new User(user.getId().toString(), user.getPassword(),
                user.isEnable(), true, true, true, user.getAuthorities());

        return detail;
    }

}
