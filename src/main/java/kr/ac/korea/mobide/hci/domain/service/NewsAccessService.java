package kr.ac.korea.mobide.hci.domain.service;

import kr.ac.korea.mobide.hci.domain.model.news.News;
import kr.ac.korea.mobide.hci.domain.model.user.User;
import kr.ac.korea.mobide.hci.domain.model.user.UserHistory;

/**
 * Created with IntelliJ IDEA.
 * User: kulee
 * Date: 13. 10. 18.
 * Time: 오후 10:17
 * To change this template use File | Settings | File Templates.
 */
public interface NewsAccessService {

    public UserHistory access(User user, News news);

}
