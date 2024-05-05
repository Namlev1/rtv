package rtv.pl.rtvshop.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rtv.pl.rtvshop.Cart;
import rtv.pl.rtvshop.model.Order;
import rtv.pl.rtvshop.security.OrderService;

import java.security.Principal;

@Controller
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);
    private final OrderService service;

    @GetMapping
    public String showOrders(Model model, Principal principal) {
        model.addAttribute("orders", service.getOrders(principal.getName()));
        log.info("Showing orders: {}", service.getOrders(principal.getName()));
        return "order";
    }

    @PostMapping
    public String createOrder(Model model, Principal principal, HttpSession session) {
        service.saveOrder(principal, session);
        model.addAttribute("isOrderCreated", true);
        return "cart";
    }
}
