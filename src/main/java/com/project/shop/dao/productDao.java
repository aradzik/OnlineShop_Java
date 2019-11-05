package com.project.shop.dao;
import com.project.shop.entity.Product;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface productDao extends CrudRepository<Product, Integer> {
    public Product findByNamep(String namep);

     @Override
    public List<Product> findAll();
}
