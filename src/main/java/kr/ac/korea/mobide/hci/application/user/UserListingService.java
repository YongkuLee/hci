package kr.ac.korea.mobide.hci.application.user;

import kr.ac.korea.mobide.hci.domain.model.email.Email;

import java.util.List;

public interface UserListingService {
    List<Email> allEmails();
}
