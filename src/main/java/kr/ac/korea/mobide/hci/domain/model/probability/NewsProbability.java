package kr.ac.korea.mobide.hci.domain.model.probability;

import kr.ac.korea.mobide.hci.domain.model.news.News;
import kr.ac.korea.mobide.hci.domain.model.news.NewsType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
public class NewsProbability {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumns(value = {@JoinColumn(name = "newsId"), @JoinColumn(name = "newsTitle")})
    private News news;

    private double probability;

    public NewsProbability(News news, double newsCount) {
        this.news = news;
        this.probability = ((double) 1) / newsCount;
    }

}
