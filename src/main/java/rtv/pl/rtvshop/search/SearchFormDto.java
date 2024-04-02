package rtv.pl.rtvshop.search;

import lombok.Data;

import java.util.List;

@Data
public class SearchFormDto {
    private String name;
    private Double minPrice;
    private Double maxPrice;
    private List<String> brands;
    private List<Boolean> accessibility;
}
