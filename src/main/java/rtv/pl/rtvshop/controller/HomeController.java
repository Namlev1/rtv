package rtv.pl.rtvshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import rtv.pl.rtvshop.repository.ItemRepository;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final ItemRepository repository;

    @GetMapping("/")
    public String defaultPage() {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(Model model, Authentication authentication) {
        model.addAttribute("items", repository.findTop8ByAccessibilityIsTrue());
        model.addAttribute("authentication", authentication);
        return "home";
    }

    @GetMapping("/add")
    public void add() {
        System.err.println("Adding must be implemented!");
    }


}