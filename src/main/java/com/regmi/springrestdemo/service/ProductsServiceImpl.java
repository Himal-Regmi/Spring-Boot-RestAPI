package com.regmi.springrestdemo.service;

import com.regmi.springrestdemo.dao.ProductDao;
import com.regmi.springrestdemo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {

    private ProductDao productDao;

    @Autowired
    public ProductsServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    @Transactional
    public List<Product> getProducts() {
        return productDao.getProducts();
    }

    @Override
    @Transactional
    public Product getProduct(int id) {
        return productDao.getProduct(id);
    }

    @Override
    @Transactional
    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    @Transactional
    public void deleteProduct(int id) {
        productDao.deleteProduct(id);
    }
}
