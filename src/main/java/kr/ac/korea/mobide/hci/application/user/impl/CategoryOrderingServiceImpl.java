package kr.ac.korea.mobide.hci.application.user.impl;

import kr.ac.korea.mobide.hci.application.user.CategoryOrderingService;
import kr.ac.korea.mobide.hci.domain.model.news.News;
import kr.ac.korea.mobide.hci.domain.model.news.NewsRepository;
import kr.ac.korea.mobide.hci.domain.model.news.NewsType;
import kr.ac.korea.mobide.hci.domain.model.probability.*;
import kr.ac.korea.mobide.hci.domain.model.user.User;
import kr.ac.korea.mobide.hci.domain.model.user.UserHistoryRepository;
import kr.ac.korea.mobide.hci.domain.model.user.UserId;
import kr.ac.korea.mobide.hci.domain.model.user.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: kulee
 * Date: 13. 10. 18.
 * Time: 오후 9:58
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class CategoryOrderingServiceImpl implements CategoryOrderingService {

    private NewsRepository newsRepository;

    private UserHistoryRepository historyRepository;

    private UserRepository userRepository;

    private UserProbabilityRepository probabilityRepository;

    @Override
    public List<NewsType> order(UserId userId, NewsType type) {


        User user = userRepository.findOne(userId);

        List<UserProbability> _userP = probabilityRepository.findByUser(user);
        UserProbability probability;
        if (_userP == null || _userP.size() == 0) {
            probability = generateUserProbability(user);
        } else {
            probability = _userP.get(0);
        }

        probabilityRepository.save(probability);

        List<NewsType> order = new ArrayList<NewsType>();
        List<TypeProbability> probabilities = new ArrayList<TypeProbability>();

        if (type == null) {
            for (TypeProbability t : probability.getTypeProbabilities()) {
                probabilities.add(t);
            }
            Collections.sort(probabilities);
            for (TypeProbability p : probabilities) {
                order.add(p.getType());
            }
            return order;

        }

        for (TransitionProbability tp : probability.getTransitionProbabilities()) {
            if (tp.getType().getValue() == type.getValue()) {
                for (TypeProbability t : tp.getProbabilities()) {
                    probabilities.add(t);
                }
                Collections.sort(probabilities);
                for (TypeProbability p : probabilities) {
                    order.add(p.getType());
                }
                return order;
            }
        }

        return Arrays.asList(NewsType.values());

    }

    private UserProbability generateUserProbability(User user) {
        List<News> newses = newsRepository.findAll();
        UserProbability userProbability = new UserProbability();
        userProbability.setUser(user);

        HashSet<TransitionProbability> ts = new HashSet<TransitionProbability>();

        for (NewsType type : NewsType.values()) {
            TransitionProbability t = new TransitionProbability();
            t.setType(type);
            HashSet<TypeProbability> types = new HashSet<TypeProbability>();
            for (NewsType _nt : NewsType.values()) {
                TypeProbability typeProbability = new TypeProbability(_nt);
                types.add(typeProbability);
            }
            t.setProbabilities(types);
            ts.add(t);
        }

        userProbability.setTransitionProbabilities(ts);

        HashSet<EmissionProbability> es = new HashSet<EmissionProbability>();

        for (NewsType type : NewsType.values()) {
            EmissionProbability e = new EmissionProbability();
            e.setType(type);
            HashSet<NewsProbability> types = new HashSet<NewsProbability>();
            for (News _ns : newses) {
                NewsProbability newsProbability = new NewsProbability(_ns, newses.size());
                types.add(newsProbability);
            }
            e.setProbabilities(types);
            es.add(e);
        }

        userProbability.setEmissionProbabilities(es);


        HashSet<TypeProbability> ys = new HashSet<TypeProbability>();
        for (NewsType _nt : NewsType.values()) {
            TypeProbability typeProbability = new TypeProbability(_nt);
            ys.add(typeProbability);
        }
        userProbability.setTypeProbabilities(ys);

        return userProbability;
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
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Inject
    public void setProbabilityRepository(UserProbabilityRepository probabilityRepository) {
        this.probabilityRepository = probabilityRepository;
    }
}
