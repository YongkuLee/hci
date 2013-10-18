package kr.ac.korea.mobide.hci.domain.model.probability;

import kr.ac.korea.mobide.hci.domain.model.news.NewsType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: kulee
 * Date: 13. 10. 18.
 * Time: 오후 11:51
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Data
@NoArgsConstructor
public class TransitionProbability {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private NewsType type;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<TypeProbability> probabilities;

    public double[] types() {
        int size = this.probabilities.size();

        double[] result = new double[size];

        for (TypeProbability typeProbability : this.probabilities) {
            result[typeProbability.getType().getValue()] = typeProbability.getProbability();
        }

        return result;
    }

    public void setTypes(double[] values) {
        for (TypeProbability typeProbability : this.probabilities) {
            typeProbability.setProbability(values[typeProbability.getType().getValue()]);
        }
    }

}
