package kr.ac.korea.mobide.hci.domain.model.probability;

import kr.ac.korea.mobide.hci.domain.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kulee
 * Date: 13. 10. 19.
 * Time: 오전 12:07
 * To change this template use File | Settings | File Templates.
 */
public interface UserProbabilityRepository extends JpaRepository<UserProbability, Long> {

    public List<UserProbability> findByUser(User user);

}
