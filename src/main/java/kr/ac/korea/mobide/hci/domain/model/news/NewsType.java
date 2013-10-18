package kr.ac.korea.mobide.hci.domain.model.news;

/**
 * Created with IntelliJ IDEA.
 * User: kulee
 * Date: 13. 10. 18.
 * Time: 오후 6:29
 * To change this template use File | Settings | File Templates.
 */
public enum NewsType {
    politic(0), entertainment(1), sports(2), money(3), life(4);

    private final int id;

    NewsType(int id) {
        this.id = id;
    }

    public int getValue() {
        return id;
    }
}
