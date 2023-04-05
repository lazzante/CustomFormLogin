package CustomFormLogin.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping ("/index")
    public String ındex(){
        return "index";
    }

    @RequestMapping("/login-error")
    public String loginError(){
        return "login-error";
    }


    @RequestMapping("/admin")
    public String getAdminPage(){
        return "admin";
    }

}
