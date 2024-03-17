package rtv.pl.rtvshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import rtv.pl.rtvshop.repository.ItemRepository;

@Controller
@RequestMapping("/search")
public class SearchController {
    private final ItemRepository repository;

    @Autowired
    public SearchController(ItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String search(@RequestParam String name, Model model) {
        model.addAttribute("foundItems", repository.findByNameContaining(name));
        return "search";
    }
}
