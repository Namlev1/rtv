package rtv.pl.rtvshop;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import rtv.pl.rtvshop.model.Item;

@Data
@Entity
@NoArgsConstructor(force = true)
public class CartItem {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private final Item item;
    private int counter;
    private double sum;

    public CartItem(Item item) {
        this.item = item;
        counter = 1;
        sum = item.getPrice();
    }

    public void increaseCounter() {
        counter++;
        recalculate();
    }

    public void decreaseCounter() {
        if (counter > 0) {
            counter--;
            recalculate();
        }
    }

    private void recalculate() {
        sum = counter * item.getPrice();
    }

    public boolean hasZeroItems() {
        return counter == 0;
    }
}
