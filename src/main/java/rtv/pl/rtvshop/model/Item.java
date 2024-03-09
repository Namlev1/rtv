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

    public Item(String name, double price, double rating, String img) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.img = img;
    }

}