package rtv.pl.rtvshop.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
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
    public String showForm(Model model) {
        model.addAttribute("registrationForm", new RegistrationForm());
        return "registration";
    }

    @PostMapping
    public String register(@Valid RegistrationForm form,
                           Errors error) {
        if(error.hasErrors()) {
            return "registration";
        }
        userRegistrationService.registerUser(form);
        return "redirect:/login";
    }

}
