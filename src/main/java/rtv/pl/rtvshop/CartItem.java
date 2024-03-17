package rtv.pl.rtvshop;

import lombok.Data;
import rtv.pl.rtvshop.model.Item;

@Data
public class CartItem {
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
