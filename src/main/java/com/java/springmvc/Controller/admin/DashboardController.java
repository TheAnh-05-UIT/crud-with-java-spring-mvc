package com.java.springmvc.Controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {

    @RequestMapping("/admin")
    public String getDashboardAdmin() {
        return "/admin/dashboard/view-dashboard";
    }
}
