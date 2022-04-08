package org.example.dao;

import org.example.entity.Manufacturer;
import org.example.entity.Product;

public interface ProductDao {
    Iterable<Product> findAll();
    public String findNameById(Long id);
    Product findById(Long id);
    void insert(Product product);
    void update(Product product);
    void deleteById(Long id);
}
