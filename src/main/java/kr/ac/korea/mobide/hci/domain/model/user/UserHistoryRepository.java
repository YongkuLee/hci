package kr.ac.korea.mobide.hci.domain.model.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kulee
 * Date: 13. 10. 18.
 * Time: 오후 10:16
 * To change this template use File | Settings | File Templates.
 */
public interface UserHistoryRepository extends JpaRepository<UserHistory, Long> {

    public List<UserHistory> findByUser(User user);

}
