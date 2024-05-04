package rtv.pl.rtvshop.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rtv.pl.rtvshop.model.AddItemForm;
import rtv.pl.rtvshop.service.AddItemService;

@Controller
@RequestMapping("/add")
@RequiredArgsConstructor
public class AddItemController {
    private final AddItemService service;

    @GetMapping
    public String showAddPage(Model model) {
        model.addAttribute("addItemForm", new AddItemForm());
        model.addAttribute("itemAdded", false);
        return "add";
    }

    @PostMapping
    public String register(@Valid AddItemForm form,
                           Errors error,
                           Model model) {
        if (error.hasErrors()) {
            return "add";
        }
        model.addAttribute("addItemForm", new AddItemForm());
        model.addAttribute("itemAdded", true);
        service.saveItem(form);
        return "add";
    }

}
