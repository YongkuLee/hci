package kr.ac.korea.mobide.hci.application.news.impl;

import kr.ac.korea.mobide.hci.application.news.ListingService;
import kr.ac.korea.mobide.hci.domain.model.news.News;
import kr.ac.korea.mobide.hci.domain.model.news.NewsRepository;
import kr.ac.korea.mobide.hci.domain.model.news.NewsType;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kulee
 * Date: 13. 10. 18.
 * Time: 오후 6:42
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ListingServiceImpl implements ListingService {

    private NewsRepository newsRepository;

    @Override
    public List<News> news() {
        return newsRepository.findAll();
    }

    @Override
    public List<News> news(NewsType type) {
        return newsRepository.findByType(type);
    }

    @Inject
    public void setNewsRepository(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }
}
