package rtv.pl.rtvshop.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private double price;
    private double rating;
    @Column(length = 500)
    private String img;
    private String brand;
    private boolean accessibility;
    private Category category;

    public Item(String name, double price, double rating, String img, String brand, boolean accessibility, Category category) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.img = img;
        this.brand = brand;
        this.accessibility = accessibility;
        this.category = category;
    }
}