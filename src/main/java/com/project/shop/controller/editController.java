package com.project.shop.controller;
import com.project.shop.controller.UserController;
import com.project.shop.dao.userDao;
import com.project.shop.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class editController {
    @Autowired
    private userDao dao;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String profilePage(Model m) {//dodanie do modelu listy wszystkich użytkowników
        m.addAttribute("userlist", dao.findAll());//zwrócenie nazwy widoku wyświetlającego wszystkich użytkowników
        return "users";
    }
    @RequestMapping(value = "/editProfile", method = RequestMethod.POST)
    public String editProfilePOST(@ModelAttribute(value = "user") User user, Principal principal,@RequestParam("id") Integer ide) {
        Integer toEdit = dao.findByLogin(principal.getName()).getUserid();
        //  if (principal.getName().equals(userLogin)) { // zalogowany chce usunąć siebie
        User id = dao.findById(toEdit).get();
        id.setName(user.getName());
        id.setSurname(user.getSurname());
        id.setCity(user.getCity());
        id.setCode(user.getCode());
        dao.save(id);

        return "redirect:/users";
        //  } else return "redirect:/error";
    }
}
