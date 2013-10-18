package kr.ac.korea.mobide.hci.infrastructure.news;

import kr.ac.korea.mobide.hci.domain.model.news.News;
import kr.ac.korea.mobide.hci.domain.model.probability.UserProbability;
import kr.ac.korea.mobide.hci.domain.model.probability.UserProbabilityRepository;
import kr.ac.korea.mobide.hci.domain.model.user.User;
import kr.ac.korea.mobide.hci.domain.model.user.UserHistory;
import kr.ac.korea.mobide.hci.domain.service.NewsAccessService;
import kr.ac.korea.mobide.hci.infrastructure.news.hmm.HMM2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: kulee
 * Date: 13. 10. 18.
 * Time: 오후 10:21
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class HistoryNewsAccessService implements NewsAccessService {

    private UserProbabilityRepository probabilityRepository;

    public UserHistory access(User user, News news) {

        List<UserProbability> userProbabilities = probabilityRepository.findByUser(user);

        if (userProbabilities != null && userProbabilities.size() > 0) {
            UserProbability probability = userProbabilities.get(0);


            double[] type = probability.type();
            double[][] transition = probability.transition();
            double[][] emission = probability.emission();

            int size = type.length;

            int[] value = new int[1];
            value[0] = news.getSequence();

            HMM2 hmm2 = new HMM2(size, emission[0].length);
            hmm2.setA(transition);
            hmm2.setB(emission);
            Vector<int[]> vector = new Vector<int[]>();
            vector.add(value);

            hmm2.train(vector);

            probability.setType(type);
            probability.setTransition(transition);
            probability.setEmission(emission);

            probabilityRepository.save(probability);
        }


        return new UserHistory(user, news);
    }

    @Inject
    public void setProbabilityRepository(UserProbabilityRepository probabilityRepository) {
        this.probabilityRepository = probabilityRepository;
    }
}
