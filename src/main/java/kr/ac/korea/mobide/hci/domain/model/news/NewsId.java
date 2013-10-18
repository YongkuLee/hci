package kr.ac.korea.mobide.hci.domain.model.news;

import kr.ac.korea.mobide.hci.core.IdGenerator;
import kr.ac.korea.mobide.hci.domain.shared.ValueObject;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.math.NumberUtils;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Created with IntelliJ IDEA.
 * User: kulee
 * Date: 13. 10. 18.
 * Time: 오후 6:20
 * To change this template use File | Settings | File Templates.
 */
@Embeddable
@Getter
@NoArgsConstructor
public class NewsId implements ValueObject<NewsId> {

    private long number;

    private String title;

    public NewsId(String title) {
        this.number = IdGenerator.sId();
        this.title = title;
    }

    public NewsId(long number, String title) {
        this.number = number;
        this.title = title;
    }

    public int getNumberInt() {
        return NumberUtils.toInt(Long.toString(this.number));
    }

    @Override
    public boolean sameValueOf(NewsId other) {
        return this.number == other.getNumber() && this.title.equals(other.getTitle());
    }
}
