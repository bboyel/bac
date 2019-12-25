package com.erenkov.bac.controllers;

import com.erenkov.bac.AppUser;
import com.erenkov.bac.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepo userRepo;

    @RequestMapping(value = { "/registration"}, method = RequestMethod.GET)
    public String viewRegistrationPage(Model model) {
        return "registration";
    }



    @RequestMapping(value = "/add_user", method = RequestMethod.POST)
    public String addUser(AppUser appUser, Model model) {
//        model.addAttribute("title", "Logout");
        AppUser userFromDb = userRepo.findByUserName(appUser.getUserName());
        if (userFromDb != null){
            model.addAttribute("message", "User exists!");
            return "registration";
        }
        appUser.setEnabled(true);
        userRepo.save(appUser);

        return "redirect:/login";
    }

}
