package com.project.shop;

import com.project.shop.dao.userDao;
import com.project.shop.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication

public class ShopApplication {

    @Autowired
    private userDao dao;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {

        SpringApplication.run(ShopApplication.class, args);
    }

    @PostConstruct
    public void init() {
//        dao.save(new User("admin", "admin", "admin", passwordEncoder.encode("passwd"),"lublin","20-140","admin@admin.pl"));
//        dao.save(new User("ola", "radzik", "olar", passwordEncoder.encode("ola"),"lublin","20-010","ola@ola.pl"));
//        dao.save(new User("ala", "los", "alal", passwordEncoder.encode("ala"),"lublin","20-140","ala@ala.pl"));
//        dao.save(new User("jan", "kowal", "jank", passwordEncoder.encode("jan"),"warszawa","00-540","jan@jan.pl"));

    }
}
