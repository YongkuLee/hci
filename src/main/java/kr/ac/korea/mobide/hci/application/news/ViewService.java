package kr.ac.korea.mobide.hci.application.news;

import kr.ac.korea.mobide.hci.domain.model.news.News;
import kr.ac.korea.mobide.hci.domain.model.user.UserId;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kulee
 * Date: 13. 10. 18.
 * Time: 오후 9:03
 * To change this template use File | Settings | File Templates.
 */
public interface ViewService {
    public News view(UserId userId, long id, String title);
}
