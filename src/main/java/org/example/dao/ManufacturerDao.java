package org.example.dao;

import org.example.entity.Manufacturer;


public interface ManufacturerDao {
    Iterable<Manufacturer> findAll();
    public String findNameById(Long id);
    Manufacturer findById(Long id);
    void insert(Manufacturer manufacturer);
    void update(Manufacturer manufacturer);
    void deleteById(Long id);
}
