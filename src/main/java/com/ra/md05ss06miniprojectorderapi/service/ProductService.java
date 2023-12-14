package com.ra.md05ss06miniprojectorderapi.service;

import com.ra.md05ss06miniprojectorderapi.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product save(Product product);

    Product getProductById(Long id);

    Product update(Long id, Product product);

    boolean delete(Long id);
}
