package com.erenkov.bac.controllers;

//import com.erenkov.bac.PersonDAO;
//import com.erenkov.bac.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erenkov.bac.PersonForm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;

import com.erenkov.bac.WebUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;


import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
    public String welcomePage() {
        return "welcome";
    }


}
    //DB
//    @Autowired
//    private PersonDAO personDAO;


//    @ResponseBody
//    @RequestMapping("/")
//    public String index() {
//        Iterable<Person> all = personDAO.findAll();
//
//        StringBuilder sb = new StringBuilder();
//
//        all.forEach(p -> sb.append(p.getFullName() + "<br>"));
//
//        return sb.toString();
//    }
//=================================
//    //Thymeleaf
////    private static List<Person> persons = new ArrayList<Person>();
////
////    static {
////        persons.add(new Person("Bill", "Gates"));
////        persons.add(new Person("Steve", "Jobs"));
////    }
//
//    // ​​​​​​​
////    // Вводится (inject) из application.properties.
////    @Value("${welcome.message}")
////    private String message;
//
////    @Value("${error.message}")
////    private String errorMessage;
//
//    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
//    public String index(Model model) {
//
////        model.addAttribute("message", message);
//
//        return "index";
//    }
//
//    @RequestMapping(value = { "/personList" }, method = RequestMethod.GET)
//    public String personList(Model model) {
//
////        model.addAttribute("persons", persons);
//
//        return "personList";
//    }
//
//    @RequestMapping(value = { "/addPerson" }, method = RequestMethod.GET)
//    public String showAddPersonPage(Model model) {
//
////        PersonForm personForm = new PersonForm();
////        model.addAttribute("personForm", personForm);
//
//        return "addPerson";
//    }
//
//    @RequestMapping(value = { "/addPerson" }, method = RequestMethod.POST)
//    public String savePerson(Model model){ //, //
////                             @ModelAttribute("personForm") PersonForm personForm) {
//
////        String firstName = personForm.getFirstName();
////        String lastName = personForm.getLastName();
//
////        if (firstName != null && firstName.length() > 0 //
////                && lastName != null && lastName.length() > 0) {
////            Person newPerson = new Person(firstName, lastName);
////            persons.add(newPerson);
//
//            return "redirect:/personList";
//        }
//
////        model.addAttribute("errorMessage", errorMessage);
////        return "addPerson";
////    }
//
////}
    //security
//    @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
//    public String welcomePage(Model model) {
//        model.addAttribute("title", "Welcome");
//        model.addAttribute("message", "This is welcome page!");
//        return "welcomePage";
//    }
//
//    @RequestMapping(value = "/admin", method = RequestMethod.GET)
//    public String adminPage(Model model, Principal principal) {
//
//        User loginedUser = (User) ((Authentication) principal).getPrincipal();
//
//        String userInfo = WebUtils.toString(loginedUser);
//        model.addAttribute("userInfo", userInfo);
//
//        return "adminPage";
//    }
//
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String loginPage(Model model) {
//
//        return "loginPage";
//    }
//
//    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
//    public String logoutSuccessfulPage(Model model) {
//        model.addAttribute("title", "Logout");
//        return "logoutSuccessfulPage";
//    }
//
//    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
//    public String userInfo(Model model, Principal principal) {
//
//        // After user login successfully.
//        String userName = principal.getName();
//
//        System.out.println("User Name: " + userName);
//
//        User loginedUser = (User) ((Authentication) principal).getPrincipal();
//
//        String userInfo = WebUtils.toString(loginedUser);
//        model.addAttribute("userInfo", userInfo);
//
//        return "userInfoPage";
//    }
//
//    @RequestMapping(value = "/403", method = RequestMethod.GET)
//    public String accessDenied(Model model, Principal principal) {
//
//        if (principal != null) {
//            User loginedUser = (User) ((Authentication) principal).getPrincipal();
//
//            String userInfo = WebUtils.toString(loginedUser);
//
//            model.addAttribute("userInfo", userInfo);
//
//            String message = "Hi " + principal.getName() //
//                    + "<br> You do not have permission to access this page!";
//            model.addAttribute("message", message);
//
//        }
//
//        return "403Page";
//    }

//}