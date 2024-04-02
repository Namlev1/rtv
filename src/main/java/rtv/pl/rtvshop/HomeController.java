package rtv.pl.rtvshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import rtv.pl.rtvshop.model.Item;
import rtv.pl.rtvshop.repository.ItemRepository;

import java.util.Optional;

@Controller
public class HomeController {
    private final ItemRepository repository;
    private final Cart cart;

    @Autowired
    public HomeController(ItemRepository repository, Cart cart) {
        this.repository = repository;
        this.cart = cart;
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("items", repository.findTop8ByAccessibilityIsTrue());
        return "home";
    }

    @GetMapping("/add")
    public void add() {
        repository.save(new Item("a", 3, 4, "aaa.com", "Samsung", true));
    }

    @GetMapping("/add/{item-id}")
    public String addItemToCart(@PathVariable("item-id") Long itemId, Model model) {

        Optional<Item> oItem = repository.findById(itemId);
        if (oItem.isPresent()) {
            Item item = oItem.get();
            cart.addItem(item);
        }
        model.addAttribute("items", repository.findTop8ByAccessibilityIsTrue());
        return "redirect:/home";
    }

    @GetMapping("/cart")
    public String cart() {
        return "cart";
    }
}