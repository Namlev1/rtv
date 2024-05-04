package rtv.pl.rtvshop.model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddItemForm {
    @NotNull(message = "Name cannot be null")
    private String name;

    @NotNull(message = "Price cannot be null")
    @DecimalMin(value = "0.01", message = "Cena musi wynosić min. 0.01zł")
    @Pattern(regexp = "\\d+(\\.\\d{1,2})?", message = "Cena musi być liczbą o max. 2 cyfrach po kropce.")
    private String price;

    @NotNull(message = "Image URL cannot be null")
    private String img;

    @NotNull(message = "Brand cannot be null")
    private String brand;

    @NotNull(message = "Accessibility cannot be null")
    private boolean accessibility;

    @NotNull(message = "Category cannot be null")
    private Category category;

    public Item toItem(){
        return new Item(name, Double.parseDouble(price), 0.0, img, brand, accessibility, category);
    }
}