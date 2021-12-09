package io.ezstudy.open.csq.domain.oauth.api;

import io.ezstudy.open.csq.domain.oauth.config.auth.SessionUser;
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
            model.addAttribute("userName", user.getName());
        }
        return "index";

    }
}
