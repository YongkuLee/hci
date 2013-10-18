package kr.ac.korea.mobide.hci.domain.model.probability;

import kr.ac.korea.mobide.hci.domain.model.news.News;
import kr.ac.korea.mobide.hci.domain.model.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: kulee
 * Date: 13. 10. 18.
 * Time: 오후 11:54
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Data
@NoArgsConstructor
public class UserProbability {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<TypeProbability> typeProbabilities;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<TransitionProbability> transitionProbabilities;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<EmissionProbability> emissionProbabilities;

    public double[] type() {
        int size = this.typeProbabilities.size();

        double[] result = new double[size];

        for (TypeProbability typeProbability : this.typeProbabilities) {
            result[typeProbability.getType().getValue()] = typeProbability.getProbability();
        }

        return result;
    }

    public double[][] transition() {
        int size = this.transitionProbabilities.size();

        double[][] result = new double[size][];
        for (TransitionProbability transitionProbability : this.transitionProbabilities) {
            result[transitionProbability.getType().getValue()] = transitionProbability.types();
        }

        return result;
    }

    public double[][] emission() {
        int size = this.emissionProbabilities.size();

        double[][] result = new double[size][];

        for (EmissionProbability emissionProbability : this.emissionProbabilities) {
            result[emissionProbability.getType().getValue()] = emissionProbability.news();
        }

        return result;
    }

    public void setType(double[] values) {
        for (TypeProbability typeProbability : this.typeProbabilities) {
            typeProbability.setProbability(values[typeProbability.getType().getValue()]);
        }
    }

    public void setTransition(double[][] values) {
        for (TransitionProbability transitionProbability : this.transitionProbabilities) {
            transitionProbability.setTypes(values[transitionProbability.getType().getValue()]);
        }
    }

    public void setEmission(double[][] values) {
        for (EmissionProbability emissionProbability : this.emissionProbabilities) {
            emissionProbability.setNews(values[emissionProbability.getType().getValue()]);
        }
    }

}
