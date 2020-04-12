package com.regmi.SpringBootDemo.service;

import com.regmi.SpringBootDemo.entity.Product;

import java.util.List;

public interface ProductsService {
    public List<Product> getProducts();

    public Product getProduct(int id);

    public void save(Product product);

    public void deleteProduct(int id);
}
