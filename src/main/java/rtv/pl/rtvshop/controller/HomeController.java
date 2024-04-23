package rtv.pl.rtvshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import rtv.pl.rtvshop.Cart;
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