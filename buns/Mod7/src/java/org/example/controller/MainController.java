package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    // Display the main page
    @GetMapping("/")
    public String getInfo() {
        return "main";
    }

    // Display information for HR
    @GetMapping("/hr_info")
    public String getHRInfo() {
        return "hr";
    }

    // Display information for managers
    @GetMapping("/manager_info")
    public String getManagerInfo() {
        return "manager";
    }
}
