package kr.ac.korea.mobide.hci.domain.model.email;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import kr.ac.korea.mobide.hci.domain.model.user.User;
import kr.ac.korea.mobide.hci.domain.shared.EntityModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString(of = "email")
@NoArgsConstructor
public class Email implements EntityModel<Email> {

    @Id
    private String email;

    private boolean verified;

    @ManyToOne
    @JoinColumn
    private User user;

    public Email(String email) {
        this.email = email;
        this.verified = false;
    }

    @Override
    public boolean sameEntityAs(Email model) {
        return this.email.equals(model.getEmail());
    }

}
