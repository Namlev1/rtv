package rtv.pl.rtvshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import rtv.pl.rtvshop.model.Item;
import rtv.pl.rtvshop.repository.ItemRepository;

@Controller
public class HomeController {
    private ItemRepository repository;

    @Autowired
    public HomeController(ItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("items", repository.findTop8By());
        return "home";
    }

    @GetMapping("/add")
    public void add() {

        repository.save(new Item("a", 3, 4, "aaa.com"));
    }
}