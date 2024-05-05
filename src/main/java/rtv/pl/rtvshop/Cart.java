package rtv.pl.rtvshop;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import rtv.pl.rtvshop.model.Item;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Data
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    private final List<CartItem> cartItems = new ArrayList<>();
    private int counter = 0;
    private double price = 0;

    public void addItem(Item item) {
        // search for item
        for (CartItem cartItem : cartItems) {
            if (cartItem.getItem().getId().equals(item.getId())) {
                cartItem.increaseCounter();
                recalculatePriceAndCounter();
                return;
            }
        }

        cartItems.add(new CartItem(item));
        recalculatePriceAndCounter();
    }

    public void remove(CartItem item) {
        // search for item
        for (CartItem cartItem : cartItems) {
            if (cartItem.equals(item)) {
                cartItems.remove(cartItem);
                recalculatePriceAndCounter();
                return;
            }
        }
    }

    public void increase(CartItem item) {
        for (CartItem cartItem : cartItems) {
            if (cartItem.equals(item)) {
                cartItem.increaseCounter();
                recalculatePriceAndCounter();
                return;
            }
        }
    }

    public void decrease(CartItem item) {
        for (CartItem cartItem : cartItems) {
            if (cartItem.equals(item)) {
                cartItem.decreaseCounter();
                recalculatePriceAndCounter();
                if (cartItem.getCounter() == 0)
                    cartItems.remove(cartItem);
                return;
            }
        }
    }

    public void clear() {
        id = null;
        cartItems.clear();
        counter = 0;
        price = 0;
    }

    private void recalculatePriceAndCounter() {
        int tempCounter = 0;
        double tempPrice = 0;
        for (CartItem cartItem : cartItems) {
            tempCounter += cartItem.getCounter();
            tempPrice += cartItem.getSum();
        }

        counter = tempCounter;
        price = tempPrice;
    }
}
