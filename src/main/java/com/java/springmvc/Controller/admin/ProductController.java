package com.java.springmvc.Controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

    @RequestMapping("/admin/product")
    public String getDashboardAdmin() {
        return "/admin/product/view-product";
    }
}
