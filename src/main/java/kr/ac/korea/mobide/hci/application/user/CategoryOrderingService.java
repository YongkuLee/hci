package kr.ac.korea.mobide.hci.application.user;

import kr.ac.korea.mobide.hci.domain.model.news.NewsType;
import kr.ac.korea.mobide.hci.domain.model.user.UserId;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kulee
 * Date: 13. 10. 18.
 * Time: 오후 9:39
 * To change this template use File | Settings | File Templates.
 */
public interface CategoryOrderingService {
    public List<NewsType> order(UserId userId, NewsType type);
}
