package com.java.springmvc.Controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.java.springmvc.domain.Product;
import com.java.springmvc.service.ProductService;
import com.java.springmvc.service.UploadFileService;

@Controller
public class ProductController {

    private final ProductService productService;
    private final UploadFileService uploadFileService;

    public ProductController(ProductService productService,
            UploadFileService uploadFileService) {
        this.productService = productService;
        this.uploadFileService = uploadFileService;
    }

    @GetMapping("/admin/product")
    public String getDashboardProduct(Model model) {
        List<Product> products = this.productService.handleGetAllProduct();
        model.addAttribute("products", products);
        return "/admin/product/view-product";
    }

    @GetMapping("/admin/product/create")
    public String getCreateProductPage(
            Model model) {
        model.addAttribute("newProduct", new Product());
        return "/admin/product/create-product";
    }

    @PostMapping("/admin/product/create")
    public String createProductFrom(
            @ModelAttribute("newProduct") Product product,
            Model model,
            @RequestParam("imageFile") MultipartFile file) {
        String imageProductFile = this.uploadFileService.handleStorefile(file, "product");
        product.setImage(imageProductFile);
        this.productService.handleCreateProduct(product);
        return "redirect:/admin/product";
    }
}
