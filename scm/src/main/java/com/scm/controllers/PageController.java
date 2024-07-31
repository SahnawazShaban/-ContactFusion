package com.scm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helpers.MessageType;
import com.scm.helpers.Message;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.Builder;

@Controller
@Builder
public class PageController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "redirect:/home";
    }

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

    // contact page
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
    @GetMapping("/register")
    public String register(Model model) {

        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);
        return "register";
    }

    // Processing register
    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processRegister(@Valid @ModelAttribute UserForm userForm, BindingResult rBindingResult,
            HttpSession session) {
        System.out.println("Processing registration");
        // fetch form data
        // UserForm
        System.out.println(userForm);

        // validate form data
        if (rBindingResult.hasErrors()) {
            return "register";
        }

        // TODO::Validate userForm[Next Video]

        // save to database

        // userservice

        // UserForm--> User
        // User user = User.builder()
        // .name(userForm.getName())
        // .email(userForm.getEmail())
        // .password(userForm.getPassword())
        // .about(userForm.getAbout())
        // .phoneNumber(userForm.getPhoneNumber())
        // .profilePic(
        // "https://www.learncodewithdurgesh.com/_next/image?url=%2F_next%2Fstatic%2Fmedia%2Fdurgesh_sir.35c6cb78.webp&w=1920&q=75")
        // .build();

        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePic(
                "https://avatars.githubusercontent.com/u/87632457?s=400&u=a9cb7225c61ccc58397216709aea19fd68af1d31&v=4");

        User savedUser = userService.saveUser(user);

        System.out.println("user saved :");

        // message = "Registration Successful"
        // add the message:

        Message message = Message.builder().content("Registration Successful").type(MessageType.green).build();

        session.setAttribute("message", message);

        // redirectto login page
        return "redirect:/register";
    }
}
