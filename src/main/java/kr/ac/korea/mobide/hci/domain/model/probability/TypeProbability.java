package kr.ac.korea.mobide.hci.domain.model.probability;

import kr.ac.korea.mobide.hci.domain.model.news.NewsType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: kulee
 * Date: 13. 10. 18.
 * Time: 오후 11:45
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Data
@NoArgsConstructor
public class TypeProbability implements Comparable<TypeProbability> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private NewsType type;

    private double probability;

    public TypeProbability(NewsType type) {
        this.type = type;
        this.probability = ((double) 1) / ((double) NewsType.values().length);
    }

    public static void main(String[] args) {
        TypeProbability type = new TypeProbability(NewsType.entertainment);
        System.out.println(type);
    }

    @Override
    public int compareTo(TypeProbability typeProbability) {
        if (this.probability > typeProbability.getProbability()) {
            return 1;
        } else if (this.probability < typeProbability.getProbability()) {
            return -1;
        }
        return 0;
    }
}
