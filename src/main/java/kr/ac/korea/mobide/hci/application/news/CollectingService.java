package kr.ac.korea.mobide.hci.application.news;

import kr.ac.korea.mobide.hci.domain.model.news.NewsType;

/**
 * Created with IntelliJ IDEA.
 * User: kulee
 * Date: 13. 10. 18.
 * Time: 오후 6:36
 * To change this template use File | Settings | File Templates.
 */
public interface CollectingService {

    void addNews(String title, String content, NewsType newsType);

}
