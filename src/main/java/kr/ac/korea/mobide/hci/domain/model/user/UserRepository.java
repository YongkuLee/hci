package kr.ac.korea.mobide.hci.domain.model.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, UserId> {
    @Query("select u from User as u join u.emails as e where e.email = :email")
    User findByEmail(@Param("email") String email);
}
