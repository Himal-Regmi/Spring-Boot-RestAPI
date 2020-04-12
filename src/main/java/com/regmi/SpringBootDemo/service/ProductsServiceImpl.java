package com.regmi.SpringBootDemo.service;

import com.regmi.SpringBootDemo.dao.ProductDao;
import com.regmi.SpringBootDemo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {


    private ProductDao productDao;
    @Autowired
    public ProductsServiceImpl(ProductDao theproductdao) {
        this.productDao = theproductdao;
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
