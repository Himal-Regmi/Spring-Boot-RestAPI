package com.regmi.SpringBootDemo.dao;

import com.regmi.SpringBootDemo.entity.Product;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao{
//    @Autowired
    private EntityManager entityManager;

    @Autowired
    public ProductDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Product> getProducts() {
        Session session = entityManager.unwrap(Session.class);

        Query<Product> query= session.createQuery("from Product",Product.class);
        List<Product> products= query.getResultList();

        return products;
    }

    @Override
    public Product getProduct(int id) {
        Session session = entityManager.unwrap(Session.class);

        Product product = session.get(Product.class,id);
        return product;
    }

    @Override
    public void save(Product product) {
        Session session = entityManager.unwrap(Session.class);

        session.saveOrUpdate(product);
    }

    @Override
    public void deleteProduct(int id) {
        Session session = entityManager.unwrap(Session.class);

        Product product = session.get(Product.class,id);
        session.delete(product);
    }
}
