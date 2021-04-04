package com.regmi.springrestdemo.dao;

import com.regmi.springrestdemo.entity.Product;
import java.util.List;

public interface ProductDao {
    public List<Product> getProducts();

    public Product getProduct(int id);

    public void save(Product product);

    public void deleteProduct(int id);
}
