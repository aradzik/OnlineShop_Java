package com.project.shop.controller;

import com.project.shop.dao.bagDao;
import com.project.shop.dao.productDao;
import com.project.shop.dao.userDao;
import com.project.shop.entity.Bag;
import com.project.shop.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class BagController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private bagDao dao;
    @Autowired
    private productDao daoproduct;
    @Autowired
    private userDao daouser;

    @RequestMapping(value = "/bag", method = RequestMethod.GET)
    public String bag(Model m, Model n, Principal principal) {
        Integer logUser = daouser.findByLogin(principal.getName()).getUserid();
            m.addAttribute("baglist", dao.findByUserid(logUser));
            n.addAttribute("productlist", daoproduct.findAll());
            return "bag";


    }

    @GetMapping("/delete1")
    public String deleteUser(@RequestParam int delProduct) {
        Bag toDelete = dao.findByProdbagid(delProduct);
                dao.delete(toDelete);
                return "redirect:/bag";
    }


}
