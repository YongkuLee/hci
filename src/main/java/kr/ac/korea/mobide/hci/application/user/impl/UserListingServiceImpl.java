package kr.ac.korea.mobide.hci.application.user.impl;

import kr.ac.korea.mobide.hci.application.user.UserListingService;
import kr.ac.korea.mobide.hci.domain.model.email.Email;
import kr.ac.korea.mobide.hci.domain.model.user.User;
import kr.ac.korea.mobide.hci.domain.model.user.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserListingServiceImpl implements UserListingService {

    private UserRepository userRepository;

    @Override
    public List<Email> allEmails() {

        List<Email> emails = new ArrayList<Email>();

        for (User user : userRepository.findAll()) {
            emails.addAll(user.getEmails());
        }

        return emails;
    }

    @Inject
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
