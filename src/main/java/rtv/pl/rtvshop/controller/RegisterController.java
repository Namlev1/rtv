package rtv.pl.rtvshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rtv.pl.rtvshop.model.RegistrationForm;
import rtv.pl.rtvshop.service.UserRegistrationService;

@Controller
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegisterController {
    private final UserRegistrationService userRegistrationService;

    @GetMapping
    public String register() {
        return "registration";
    }

    @PostMapping
    public String register(RegistrationForm form) {
        userRegistrationService.registerUser(form);
        return "redirect:/login";
    }

}
