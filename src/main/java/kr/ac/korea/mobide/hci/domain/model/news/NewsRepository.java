package kr.ac.korea.mobide.hci.domain.model.news;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kulee
 * Date: 13. 10. 18.
 * Time: 오후 6:22
 * To change this template use File | Settings | File Templates.
 */

public interface NewsRepository extends JpaRepository<News, NewsId> {
    @Query("select n from News as n where n.id.number = :number")
    public List<News> findByNumber(@Param("number") long number);

    @Query("select n from News as n where n.id.title = :title")
    public List<News> findByTitle(@Param("title") String title);

    public List<News> findByType(NewsType type);
}
