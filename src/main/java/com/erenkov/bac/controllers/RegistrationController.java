package com.erenkov.bac.controllers;


import com.erenkov.bac.entity.Role;
import com.erenkov.bac.entity.User;
import com.erenkov.bac.dao.UserDAO;
import com.erenkov.bac.repo.RoleRepo;
import com.erenkov.bac.services.SecurityService;
import com.erenkov.bac.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class RegistrationController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @RequestMapping(value = { "/registration"}, method = RequestMethod.GET)
    public String viewRegistrationPage(Model model) {
        return "registration";
    }

    @RequestMapping(value = "/add_user", method = RequestMethod.POST)
    public String addUser(User user, Model model) {
        User userFromDb = userDAO.findUserAccount(user.getUserName());
        if (userFromDb != null){
            model.addAttribute("message", "User exists!");
            return "registration";
        }
        user.setEnabled(true);
        user.setUserName("Mike");
        user.setStatistic(0L);
        user.setEncrytedPassword("123");

        Role usRole= new Role();
        usRole.setRoleName("ROLE_USER");
        roleRepo.saveAndFlush(usRole);

         userService.save(user);
         //securityService.autoLogin(user.getUserName(), user.getEncrytedPassword());

        return "redirect:/login";
    }

}
