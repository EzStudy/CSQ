package io.ezstudy.open.csq.domain.oauth.api;

import io.ezstudy.open.csq.domain.oauth.config.auth.SessionUser;
import java.util.Enumeration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class UserApi {

    private final HttpSession httpSession;


    @GetMapping("/")
    public String login(Model model) {

        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user != null){
            System.out.println(user.getName());
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }


    @GetMapping("/loginPage")
    public String login(){
        return "login";
    }

    @GetMapping("/accessDeniedPage")
    public String accessDeniedPage(){
        return "accessDeniedPage";
    }
}
