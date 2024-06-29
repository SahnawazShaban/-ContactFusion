package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(Model model){
        //Model is object from 'org.springframework.ui.Model'
        System.out.println("Home page handler.");

        // sending data to view
        model.addAttribute("name", "Sahnawaz Shaban");
        model.addAttribute("youTube_channel", "ElizaElix");
        model.addAttribute("gitHub_Repo", "https://github.com/SahnawazShaban");
        return "home";
    }
}
