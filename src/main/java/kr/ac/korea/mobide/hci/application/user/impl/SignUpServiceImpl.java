package kr.ac.korea.mobide.hci.application.user.impl;

import kr.ac.korea.mobide.hci.application.user.SignUpService;
import kr.ac.korea.mobide.hci.domain.model.email.Email;
import kr.ac.korea.mobide.hci.domain.model.email.EmailRepository;
import kr.ac.korea.mobide.hci.domain.model.user.User;
import kr.ac.korea.mobide.hci.domain.model.user.UserRepository;
import kr.ac.korea.mobide.hci.infrastructure.security.Encriptor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@Service
@Transactional
public class SignUpServiceImpl implements SignUpService {

	private EmailRepository emailRepository;

	private UserRepository userRepository;

	@Override
	public User signUp(String email, String password, String image) {

		Email emailObj = new Email(email);
		emailRepository.save(emailObj);

		User user = new User(emailObj, Encriptor.encript(password), image);
		userRepository.save(user);

		return user;
	}

	@Inject
	public void setEmailRepository(EmailRepository emailRepository) {
		this.emailRepository = emailRepository;
	}

	@Inject
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
}
