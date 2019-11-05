package com.project.shop.entity;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
//@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userid;
   // @NotNull
  //  @Pattern(regexp = "[a-zA-Z]{2,30}", message="Podaj poprawnie imię")
    private String name;
   // @NotNull

    private String surname;
  //  @NotNull

    private String login;
  //  @NotNull

    private String password;
  //  @NotNull

    private String city;
 //   @NotNull

    private String code;

    private String mail;

    public User() {
    }

    public User(String name, String surname, String login, String password, String city, String code, String mail) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.city = city;
        this.code = code;
        this.mail = mail;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
