package rtv.pl.rtvshop.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rtv.pl.rtvshop.model.AddItemForm;

@Controller
@RequestMapping("/add")
public class AddItemController {

    @GetMapping
    public String showAddPage(Model model) {
        model.addAttribute("addItemForm", new AddItemForm());
        return "add";
    }

    @PostMapping
    public String register(@Valid AddItemForm form,
                           Errors error,
                           Model model) {
        if (error.hasErrors()) {
            return "add";
        }
        model.addAttribute("itemAdded", true);
        return "redirect:/add";
    }

}
