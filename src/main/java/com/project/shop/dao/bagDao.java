package com.project.shop.dao;

import com.project.shop.entity.Bag;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface bagDao extends CrudRepository<Bag, Integer> {

    public List<Bag> findByUserid(int userid);
    public Bag findByProdbagid(int prodbagid);

    @Override
    public List<Bag> findAll();
}
