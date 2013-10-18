package kr.ac.korea.mobide.hci.application.news;

import kr.ac.korea.mobide.hci.domain.model.news.News;
import kr.ac.korea.mobide.hci.domain.model.news.NewsType;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kulee
 * Date: 13. 10. 18.
 * Time: 오후 6:41
 * To change this template use File | Settings | File Templates.
 */
public interface ListingService {

    List<News> news();

    List<News> news(NewsType type);
}
