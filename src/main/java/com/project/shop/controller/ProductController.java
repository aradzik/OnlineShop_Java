package com.project.shop.controller;

import java.security.Principal;

import com.project.shop.dao.bagDao;
import com.project.shop.dao.userDao;
import com.project.shop.entity.Bag;
import com.project.shop.entity.Product;
import com.project.shop.dao.productDao;
import com.project.shop.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;

@Controller
public class ProductController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private productDao dao;
    @Autowired
    private bagDao daobag;
    @Autowired
    private userDao daouser;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String productsPage(Model m) {//dodanie do modelu listy wszystkich użytkowników
        m.addAttribute("productlist", dao.findAll());//zwrócenie nazwy widoku wyświetlającego wszystkich użytkowników
        return "products";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String productsIndex(Model m) {//dodanie do modelu listy wszystkich użytkowników
        m.addAttribute("productlist", dao.findAll());//zwrócenie nazwy widoku wyświetlającego wszystkich użytkowników
        return "index";
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String productsMain(Model m) {//dodanie do modelu listy wszystkich użytkowników
        m.addAttribute("productlist", dao.findAll());//zwrócenie nazwy widoku wyświetlającego wszystkich użytkowników
        return "index";
    }

    @RequestMapping(value = "/addBag", method = RequestMethod.POST)
    public String addProductPost(@ModelAttribute(value = "productAdd1") Bag bag,Principal principal, @ModelAttribute("productid") Integer idproduct) {

        Integer loggedId = daouser.findByLogin(principal.getName()).getUserid();
        bag.setUserid(loggedId);
        bag.setProductid(idproduct);
        daobag.save(bag);

        return "redirect:/bag";
    }

    @RequestMapping(value = "/addBag", method = RequestMethod.GET)
    public String addProduct(Model m) {

        m.addAttribute("productAdd1", new Bag());

        return "redirect:/bag";
    }

}
