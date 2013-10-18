package kr.ac.korea.mobide.hci.application.news.impl;

import kr.ac.korea.mobide.hci.application.news.ViewService;
import kr.ac.korea.mobide.hci.domain.model.news.News;
import kr.ac.korea.mobide.hci.domain.model.news.NewsRepository;
import kr.ac.korea.mobide.hci.domain.model.user.UserHistory;
import kr.ac.korea.mobide.hci.domain.model.user.UserHistoryRepository;
import kr.ac.korea.mobide.hci.domain.model.user.UserId;
import kr.ac.korea.mobide.hci.domain.model.user.UserRepository;
import kr.ac.korea.mobide.hci.domain.service.NewsAccessService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kulee
 * Date: 13. 10. 18.
 * Time: 오후 9:05
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ViewServiceImpl implements ViewService {

    private UserRepository userRepository;

    private NewsRepository newsRepository;

    private UserHistoryRepository historyRepository;

    private NewsAccessService newsAccessService;

    @Override
    public News view(UserId userId, long id, String title) {
        List<News> newses = newsRepository.findByNumber(id);

        for (News news : newses) {
            if (news.getId().getTitle().contains(title)) {
                history(userId, news);
                return news;
            }
        }

        return null;
    }

    public void history(UserId userId, News news) {
        UserHistory history = newsAccessService.access(userRepository.findOne(userId), news);
        historyRepository.save(history);
    }

    @Inject
    public void setNewsRepository(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Inject
    public void setHistoryRepository(UserHistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Inject
    public void setNewsAccessService(NewsAccessService newsAccessService) {
        this.newsAccessService = newsAccessService;
    }

    @Inject
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
