package rtv.pl.rtvshop.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rtv.pl.rtvshop.Cart;
import rtv.pl.rtvshop.model.Item;
import rtv.pl.rtvshop.repository.ItemRepository;

import java.util.Optional;

@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {
    private final Cart cart;
    private final ItemRepository repository;

    @GetMapping("/add/{item-id}")
    public String addItemToCart(@PathVariable("item-id") Long itemId,
                                Model model,
                                HttpServletRequest request) {

        Optional<Item> oItem = repository.findById(itemId);
        if (oItem.isPresent()) {
            Item item = oItem.get();
            cart.addItem(item);
        }
        model.addAttribute("items", repository.findTop8ByAccessibilityIsTrue());

        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

    @PostMapping("/increase/{item_id}")
    public String increaseItem(@PathVariable("item_id") Long itemId, HttpServletRequest request) {
        cart.getCartItems().stream().filter(cartItem -> cartItem.getItem().getId().equals(itemId)).findFirst().ifPresent(cart::increase);
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

    @PostMapping("/decrease/{item_id}")
    public String decreaseItem(@PathVariable("item_id") Long itemId, HttpServletRequest request){
        cart.getCartItems().stream().filter(cartItem -> cartItem.getItem().getId().equals(itemId)).findFirst().ifPresent(cart::decrease);
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

    @PostMapping("/delete/{item_id}")
    public String deleteItem(@PathVariable("item_id") Long itemId, HttpServletRequest request){
        cart.getCartItems().stream().filter(cartItem -> cartItem.getItem().getId().equals(itemId)).findFirst().ifPresent(cart::remove);
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

    @GetMapping
    public String cart() {
        return "cart";
    }
}
