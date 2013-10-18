package kr.ac.korea.mobide.hci.application.user;

import kr.ac.korea.mobide.hci.domain.model.user.User;

public interface SignUpService {

	User signUp(String email, String password, String image);

}
