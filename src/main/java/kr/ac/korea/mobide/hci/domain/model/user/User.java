package kr.ac.korea.mobide.hci.domain.model.user;

import kr.ac.korea.mobide.hci.domain.model.email.Email;
import kr.ac.korea.mobide.hci.domain.shared.DefaultValues;
import kr.ac.korea.mobide.hci.domain.shared.EntityModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class User implements EntityModel<User> {

    @EmbeddedId
    private UserId id;

    private String username;

    private String image;

    private String password;

    private boolean enable;

    @OneToMany
    private Set<Email> emails;

    private String authorities;

    private long coin;

    public Set<GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> set = new HashSet<GrantedAuthority>();

        for (String role : this.authorities.split(",")) {
            GrantedAuthority auth = new GrantedAuthorityImpl(role);
            set.add(auth);
        }

        return set;
    }

    public void addAuthority(String role) {
        Set<GrantedAuthority> set = getAuthorities();
        set.add(new GrantedAuthorityImpl(role));
        setAuthorities(set);
    }

    public void removeAuthority(String role) {
        Set<GrantedAuthority> set = getAuthorities();
        set.remove(new GrantedAuthorityImpl(role));
        setAuthorities(set);
    }

    public void setAuthorities(Set<GrantedAuthority> set) {
        String authorities = "";
        for (GrantedAuthority authority : set) {
            authorities += authority.getAuthority();
            authorities += ",";
        }
        this.authorities = authorities.substring(0, authorities.length() - 1);
    }

    public User(Email email, String password, String image) {
        this.id = new UserId();
        this.password = password;
        this.authorities = DefaultValues.DEFAULT_AUTHORITY;
        this.enable = true;
        this.emails = new HashSet<Email>();
        this.emails.add(email);
        this.coin = 0;
        this.image = image;
    }

    @Override
    public boolean sameEntityAs(User model) {
        return this.id.sameValueOf(model.getId());
    }

}
