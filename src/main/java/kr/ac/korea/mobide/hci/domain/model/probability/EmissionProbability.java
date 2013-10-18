package kr.ac.korea.mobide.hci.domain.model.probability;

import kr.ac.korea.mobide.hci.domain.model.news.NewsType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: kulee
 * Date: 13. 10. 18.
 * Time: 오후 11:53
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Data
@NoArgsConstructor
public class EmissionProbability {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private NewsType type;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<NewsProbability> probabilities;


    public double[] news() {
        int size = this.probabilities.size();

        double[] result = new double[size];

        for (NewsProbability newsProbability : this.probabilities) {
            result[newsProbability.getNews().getSequence()] = newsProbability.getProbability();
        }

        return result;
    }

    public void setNews(double[] values) {
        for (NewsProbability newsProbability : this.probabilities) {
            newsProbability.setProbability(values[newsProbability.getNews().getSequence()]);
        }
    }
}
