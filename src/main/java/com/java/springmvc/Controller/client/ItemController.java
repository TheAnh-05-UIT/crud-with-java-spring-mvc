package com.java.springmvc.Controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.java.springmvc.domain.Product;
import com.java.springmvc.service.ProductService;

@Controller
public class ItemController {

    private final ProductService productService;

    public ItemController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/{id}")
    public String getProductPage(
            Model model,
            @PathVariable("id") Long id) {
        Product product = this.productService.handleGetProductById(id);
        model.addAttribute("id", id);
        model.addAttribute("product", product);
        return "client/product/detail-product";
    }
}