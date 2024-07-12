package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(Model model) {
        // Model is object from 'org.springframework.ui.Model'
        System.out.println("Home page handler.");

        // sending data to view
        model.addAttribute("name", "Sahnawaz Shaban");
        model.addAttribute("youTube_channel", "ElizaElix");
        model.addAttribute("gitHub_Repo", "https://github.com/SahnawazShaban");
        return "home";
    }

    @RequestMapping("/about")
    public String aboutPage(Model model) {
        model.addAttribute("isLogin", false);
        System.out.println("About Page loading.");
        return "about";
    }

    @RequestMapping("/service")
    public String servicesPage() {
        System.out.println("Servies page loading.");
        return "service";
    }

    //contact page
    @GetMapping("/contact")
    public String contact() {
        System.out.println("contact page loading.");
        return new String("contact");
    }

    // login page
    @GetMapping("/login")
    public String login() {
        System.out.println("login page loading.");
        return new String("login");
    }

    // register page
    // login page
    @GetMapping("/register")
    public String register() {
        System.out.println("signup page loading.");
        return new String("register");
    }
}
