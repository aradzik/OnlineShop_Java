package com.project.shop.dao;

import com.project.shop.entity.User;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface userDao extends CrudRepository<User, Integer> {
    public User findByLogin(String login);

    public User findByUserid(Integer userid);
    @Override
    public List<User> findAll();
}
