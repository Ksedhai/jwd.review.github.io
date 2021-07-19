package com.udacity.jwdnd.c1.review.controller;

import com.udacity.jwdnd.c1.review.model.User;
import com.udacity.jwdnd.c1.review.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class SignupController {

    private final UserService userService;

    public SignupController(UserService userService){
        this.userService = userService;
    }

    @GetMapping()
    public String getSignup(){
        return "signup";
    }

    @PostMapping()
    public String postSignup(@ModelAttribute User user, Model model){
        String signupError = null;

        if(!userService.isUsernameAvailable(user.getUsername())){
            signupError = "The Username already exists.";
        }
        if(signupError == null){
            int rowsAdded = userService.createUser(user);
            if(rowsAdded<0){
                signupError = "There was an error. Please try again and fill all the info.";
            }
        }
        if(signupError==null){
            model.addAttribute("signupSuccess", true);
            //return "login";
        }
        else{
            model.addAttribute("signupError", signupError);
        }

        return "signup";
    }
}
