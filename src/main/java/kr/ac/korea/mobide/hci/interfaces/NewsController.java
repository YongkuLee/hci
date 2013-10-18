package kr.ac.korea.mobide.hci.interfaces;

import kr.ac.korea.mobide.hci.application.news.CollectingService;
import kr.ac.korea.mobide.hci.application.news.ListingService;
import kr.ac.korea.mobide.hci.application.news.ViewService;
import kr.ac.korea.mobide.hci.application.user.CategoryOrderingService;
import kr.ac.korea.mobide.hci.domain.model.news.NewsType;
import kr.ac.korea.mobide.hci.domain.model.user.UserId;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kulee
 * Date: 13. 10. 18.
 * Time: 오후 6:34
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping("/news")
public class NewsController {

    private CollectingService collectingService;

    private ListingService listingService;

    private ViewService viewService;

    private CategoryOrderingService orderingService;

    @RequestMapping
    public String news(UserId userId, Model model) {

        model.addAttribute("newses", listingService.news());
        model.addAttribute("types", orderingService.order(userId, null));

        return "news";
    }

    @RequestMapping("/{type}")
    public String type(
            @PathVariable NewsType type,
            UserId userId,
            Model model) {

        model.addAttribute("newses", listingService.news(type));
        model.addAttribute("types", orderingService.order(userId, type));

        return "news";
    }


    @RequestMapping("/{type}/{id}/{title}")
    public String viewWithType(
            @PathVariable NewsType type,
            @PathVariable long id,
            @PathVariable String title,
            UserId userId,
            Model model) {

        model.addAttribute("news", viewService.view(userId, id, title));

        type(type, userId, model);

        return "newsView";
    }

    @RequestMapping("/add")
    public String add(String title, String content, NewsType type) {
        collectingService.addNews(title, content, type);
        return "redirect:/news";
    }

    @Inject
    public void setCollectingService(CollectingService collectingService) {
        this.collectingService = collectingService;
    }

    @Inject
    public void setListingService(ListingService listingService) {
        this.listingService = listingService;
    }

    @Inject
    public void setViewService(ViewService viewService) {
        this.viewService = viewService;
    }

    @Inject
    public void setOrderingService(CategoryOrderingService orderingService) {
        this.orderingService = orderingService;
    }
}

