package com.erenkov.bac.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginController {

    @RequestMapping(value = { "/login"}, method = RequestMethod.GET)
    public String viewloginPage(Model model) {
        return "login";
    }

}
