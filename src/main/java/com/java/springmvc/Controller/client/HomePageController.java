package com.java.springmvc.Controller.client;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.java.springmvc.domain.Product;
import com.java.springmvc.service.ProductService;

@Controller
public class HomePageController {

    private final ProductService productService;

    public HomePageController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String gẹHomePage(Model model) {
        List<Product> listProducts = this.productService.handleGetAllProduct();
        model.addAttribute("products", listProducts);
        return "client/home/view-home";
    }
}
