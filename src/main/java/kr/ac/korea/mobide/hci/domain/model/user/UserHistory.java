package kr.ac.korea.mobide.hci.domain.model.user;

import kr.ac.korea.mobide.hci.domain.model.news.News;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: kulee
 * Date: 13. 10. 18.
 * Time: 오후 10:14
 * To change this template use File | Settings | File Templates.
 */
@Data
@Entity
@NoArgsConstructor
public class UserHistory implements Comparable<UserHistory> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumns(value = {@JoinColumn(name = "newsId"), @JoinColumn(name = "newsTitle")})
    private News news;

    private Date date;

    public UserHistory(User user, News news) {
        this.user = user;
        this.news = news;
        this.date = new Date();
    }

    @Override
    public int compareTo(UserHistory userHistory) {
        return this.date.compareTo(userHistory.getDate());
    }
}
