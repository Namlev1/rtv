package rtv.pl.rtvshop.search;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import rtv.pl.rtvshop.model.Item;
import rtv.pl.rtvshop.repository.ItemRepository;

import java.util.List;
import java.util.stream.Stream;


@Controller
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {
    private final ItemRepository repository;
    private final EntityManager entityManager;

    @GetMapping
    public String search(@ModelAttribute SearchFormDto params, Model model) {

        // Execute the query
        List<Item> items = repository.findByNameContaining(params.getName());
        Stream<Item> stream = items.stream();
        List<Item> filteredItems;

        if (params.getMinPrice() != null) {
            stream = stream.filter(item -> item.getPrice() >= params.getMinPrice());
        }
        if (params.getMaxPrice() != null) {
            stream = stream.filter(item -> item.getPrice() <= params.getMaxPrice());
        }
        if (params.getBrands() != null && !params.getBrands().isEmpty()) {
            stream = stream.filter(item -> params.getBrands().contains(item.getBrand()));
        }
        if (params.getAccessibility() != null && !params.getAccessibility().isEmpty()) {
            stream = stream.filter(item -> params.getAccessibility().contains(item.isAccessibility()));
        }

        filteredItems = stream.toList();

        double minPrice = items.stream().mapToDouble(Item::getPrice).min().orElse(Double.MIN_VALUE);
        double maxPrice = items.stream().mapToDouble(Item::getPrice).max().orElse(Double.MAX_VALUE);
        model.addAttribute("searchText", params.getName());
        model.addAttribute("brands", items.stream().map(Item::getBrand).toList());
        model.addAttribute("foundItems", filteredItems);
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);
        model.addAttribute("foundItemsNo", items.size());
        System.out.println(items);

        return "search";
    }
}