package com.project.shop.controller;

import java.security.Principal;

import com.project.shop.dao.userDao;
import com.project.shop.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private userDao dao;

    @RequestMapping("/index")
    public String indexPage() {

        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {//zwrócenie nazwy widoku logowania-login.html
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(Model m) {//dodanie do modelu nowego użytkownika
        m.addAttribute("user", new User());//zwrócenie nazwy widoku rejestracji-register.html
        return "register";
    }

//    @RequestMapping(value = "/editProfile", method = RequestMethod.GET)
//    public String profile() {
//
//        return "editProfile1";
//    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerPagePOST(@ModelAttribute(value = "user") User user, BindingResult binding) {
        if (binding.hasErrors()) {
            return "register"; // powrót do formularza
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        dao.save(user);//przekierowanie do adresu url: /login
        return "redirect:/login";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profilePage(Model m, Principal principal) {//dodanie do modelu obiektu user -aktualnie zalogowanego użytkownika:
        m.addAttribute("user", dao.findByLogin(principal.getName()));//zwrócenie nazwy widoku profilu użytkownika-profile.html
        return "profile";
    }

//    @RequestMapping(value = "/users", method = RequestMethod.GET)
//    public String profilePage(Model m) {//dodanie do modelu listy wszystkich użytkowników
//        m.addAttribute("userlist", dao.findAll());//zwrócenie nazwy widoku wyświetlającego wszystkich użytkowników
//        return "users";
//    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam String userLogin, Principal principal) {
        User toDelete = dao.findByLogin(userLogin);

        if ("admin".equals(principal.getName())) { //zalogowany admin
            if (principal.getName().equals(userLogin)) { // zalogowany chce usunąć siebie
                dao.delete(toDelete);
                return "redirect:/logout";
            } else {
                dao.delete(toDelete);
                return "redirect:/users";
            }
        } else { //wszyscy poza adminem
            if (principal.getName().equals(userLogin)) { // zalogowany chce usunąć siebie
                dao.delete(toDelete);
                return "redirect:/logout";
            } else { //zalogowany chce usunac kogos innego
                return "delete";
            }
        }
    }

//    @RequestMapping(value = "/editProfile",method = RequestMethod.GET)
//    public String editPage(Model m) {
//
//        return "editProfile";
//    }
//    @RequestMapping(value = "/editProfile", method = RequestMethod.POST)
//    public String editPagePOST(@ModelAttribute(value = "user") User user) {
//
//       // user.setPassword(passwordEncoder.encode(user.getPassword()));
//       // dao.save(user);//przekierowanie do adresu url: /login
//        return "redirect:/profile";
//    }


//    @RequestMapping(value = "/editProfile", method = RequestMethod.POST)
//    public String editPage(@ModelAttribute(value = "user") User user) {//zwrócenie nazwy widoku logowania-login.html
//        return "editProfile";
//    }
    //   @RequestMapping(value = "/editProfile", method = RequestMethod.POST)
//    public String editProfile(@ModelAttribute(value = "user") User user) {
//
//        //dao.save(user);
//
//       return "editProfile";
//    }
//    @RequestMapping(value = "/editProfile", method = RequestMethod.GET)
//    public String editProfile(Model m) {//dodanie do modelu nowego użytkownika
//        m.addAttribute("user", new User());//zwrócenie nazwy widoku rejestracji-register.html
//        return "editProfile";
//    }
//
//    @RequestMapping(value = "/editProfile", method = RequestMethod.POST)
//    public String editProfilePOST(@ModelAttribute(value = "user") User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        dao.save(user);//przekierowanie do adresu url: /login
//        return "profile";
//    }
//    @RequestMapping(value = "/editProfile", method = RequestMethod.GET)
//    public String editProfilePOST(@ModelAttribute(value = "user1") User user, Principal principal) {
//        Integer toEdit = dao.findByLogin(principal.getName()).getUserid();
//        //  if (principal.getName().equals(userLogin)) { // zalogowany chce usunąć siebie
//        User id = dao.findById(toEdit).get();
//        id.setName(user.getName());
//        id.setSurname(user.getSurname());
//        id.setCity(user.getCity());
//        id.setCode(user.getCode());
//        dao.save(id);
//
//        return "redirect:/profile";
//        //  } else return "redirect:/error";
//    }

//    @RequestMapping(value = "/editProfile", method = RequestMethod.GET)
//    public String editProfilePOST(@ModelAttribute(value = "user1") User user, Principal principal) {
//        // Integer toEdit = dao.findByLogin(principal.getName()).getUserid(); //id zalogowanego
//        //  if (principal.getName().equals(userLogin)) { // zalogowany chce usunąć siebie
//        //user.setPassword(passwordEncoder.encode(user.getPassword()));
//        User id = dao.findByLogin(principal.getName());
//        //User toEdit = dao.findByUserid().get();
//        // User edit = dao.findById(toEdit).get();
//        id.setName(user.getName());
//        id.setSurname(user.getSurname());
//        id.setCity(user.getCity());
//        id.setCode(user.getCode());
//        dao.save(id);
//
//        return "redirect:/profile";
//        //  } else return "redirect:/error";
//    }

//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public String editProfilePOST(@ModelAttribute(value = "user1") User user,Principal principal, Model m,  BindingResult binding) {
//        if (binding.hasErrors()) {
//            return "register"; // powrót do formularza
//        }
//        User edit =  dao.findByLogin(principal.getName());
//        m.addAttribute("edit",)
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        dao.save(user);//przekierowanie do adresu url: /login
//        return "redirect:/login";
//    }


}

