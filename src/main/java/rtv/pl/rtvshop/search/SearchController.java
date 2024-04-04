package rtv.pl.rtvshop.search;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import rtv.pl.rtvshop.model.Category;
import rtv.pl.rtvshop.model.Item;
import rtv.pl.rtvshop.repository.ItemRepository;

import java.util.List;
import java.util.stream.Stream;


@Controller
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {
    private final ItemRepository repository;

    @GetMapping
    public String search(@ModelAttribute SearchFormDto params, Model model) {
        List<Item> items;

        // Sytuacja, gdy wyszukujemy tylko po kategorii (przy użyciu top banner)
        if ((params.getName() == null || params.getName().isEmpty()) && params.getCategory() != null)
            items = repository.findByCategory(params.getCategory());
        else
            items = repository.findByNameContaining(params.getName());

        List<Item> filteredItems = filter(params, items);

        double minPrice = items.stream().mapToDouble(Item::getPrice).min().orElse(Double.MIN_VALUE);
        double maxPrice = items.stream().mapToDouble(Item::getPrice).max().orElse(Double.MAX_VALUE);
        if (minPrice == maxPrice) // Only one item found
            minPrice = 0;

        addToModel(params, model, items, filteredItems, minPrice, maxPrice);

        return "search";
    }

    private void addToModel(SearchFormDto params, Model model, List<Item> items, List<Item> filteredItems, double minPrice, double maxPrice) {
        model.addAttribute("searchText", params.getName());
        model.addAttribute("searchCategory", params.getCategory());
        String searchCategoryTranslated = translateCategory(params.getCategory());
        model.addAttribute("searchCategoryTranslated", searchCategoryTranslated);
        model.addAttribute("brands", items.stream().map(Item::getBrand).distinct().toList());
        model.addAttribute("foundItems", filteredItems);
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);
        model.addAttribute("minSetPrice", params.getMinPrice() == null ? minPrice : params.getMinPrice());
        model.addAttribute("maxSetPrice", params.getMaxPrice() == null ? maxPrice : params.getMaxPrice());
        model.addAttribute("foundItemsNo", items.size());
        model.addAttribute("selectedBrands", params.getBrands());
        model.addAttribute("selectedAccessibility", params.getAccessibility());
    }

    private List<Item> filter(SearchFormDto params, List<Item> items) {
        Stream<Item> stream = items.stream();

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
        if (params.getCategory() != null) {
            stream = stream.filter(item -> item.getCategory().equals(params.getCategory()));
        }

        return stream.toList();
    }

    private String translateCategory(Category category) {
        String searchCategoryTranslated = null;
        if (category != null) {
            if (category.equals(Category.TV))
                searchCategoryTranslated = "Telewizor";
            else if (category.equals(Category.PHONE)) {
                searchCategoryTranslated = "Smartphone";
            } else if (category.equals(Category.BIG_AGD)) {
                searchCategoryTranslated = "Duże AGD";
            } else if (category.equals(Category.SMALL_AGD)) {
                searchCategoryTranslated = "Małe AGD";
            } else if (category.equals(Category.COMPUTER)) {
                searchCategoryTranslated = "Komputer";
            }
        }
        return searchCategoryTranslated;
    }
}