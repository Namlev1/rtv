package rtv.pl.rtvshop.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {

    @GetMapping("account")
    public String account(Authentication authentication, Model model) {
        model.addAttribute("account", authentication.getPrincipal());
        return "account";
    }
}
