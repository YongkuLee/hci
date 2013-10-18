package kr.ac.korea.mobide.hci.application.news.impl;

import kr.ac.korea.mobide.hci.application.news.CollectingService;
import kr.ac.korea.mobide.hci.domain.model.news.News;
import kr.ac.korea.mobide.hci.domain.model.news.NewsRepository;
import kr.ac.korea.mobide.hci.domain.model.news.NewsType;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: kulee
 * Date: 13. 10. 18.
 * Time: 오후 6:37
 * To change this template use File | Settings | File Templates.
 */
@Service
public class CollectingServiceImpl implements CollectingService {

    private NewsRepository newsRepository;

    @Override
    public void addNews(String title, String content, NewsType newsType) {
        News news = new News(title, content, newsType);

        newsRepository.save(news);
    }

    @Inject
    public void setNewsRepository(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }
}
