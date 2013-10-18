package kr.ac.korea.mobide.hci.domain.model.news;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Created with IntelliJ IDEA.
 * User: kulee
 * Date: 13. 10. 18.
 * Time: 오후 6:19
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Data
@NoArgsConstructor
public class News {

    @EmbeddedId
    private NewsId id;

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int sequence;

    private String content;

    private NewsType type;

    public News(String title, String content, NewsType type) {
        this.id = new NewsId(title);
        this.content = content;
        this.type = type;
    }
}
