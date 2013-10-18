package kr.ac.korea.mobide.hci.interfaces;

import kr.ac.korea.mobide.hci.application.user.SignUpService;
import kr.ac.korea.mobide.hci.application.user.UserListingService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;

@Controller
public class HomeContoller {

    private SignUpService signUpService;

    private UserListingService userListingService;

    @RequestMapping("/")
    public String home(Model model) {

        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        if (!auth.getName().equals("anonymousUser")) {
            for (GrantedAuthority au : auth.getAuthorities()) {
                if (au.getAuthority().equals("ROLE_USER")) {
                    return "redirect:/news";
                }
            }
        }

        return "mobile";
    }

    @RequestMapping("/login")
    public String login(Model model) {

        return "login";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(Model model) {
        model.addAttribute("emails", userListingService.allEmails());
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signuppost(String email, String password, String image) {
        signUpService.signUp(email, password, image);
        return "redirect:/signup";
    }

    @RequestMapping(value = "/signin")
    @ResponseBody
    public String signinfail() {
        return "로그인 실패";
    }

    @Inject
    public void setSignUpService(SignUpService signUpService) {
        this.signUpService = signUpService;
    }

    @Inject
    public void setUserListingService(UserListingService userListingService) {
        this.userListingService = userListingService;
    }

}
