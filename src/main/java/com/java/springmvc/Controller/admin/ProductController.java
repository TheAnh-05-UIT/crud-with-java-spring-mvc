package com.java.springmvc.Controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.springmvc.domain.Product;

@Controller
public class ProductController {

    @GetMapping("/admin/product")
    public String getDashboardProduct() {
        return "/admin/product/view-product";
    }

    @GetMapping("/admin/product/create")
    public String getCreateProductPage(
            Model model) {
        model.addAttribute("newProduct", new Product());
        return "/admin/product/create-product";
    }

    @PostMapping("/admin/product/create")
    public String getProductFrom(
            @ModelAttribute("newProduct") Product product,
            Model model) {
        return "/admin/product/create-product";
    }
}
