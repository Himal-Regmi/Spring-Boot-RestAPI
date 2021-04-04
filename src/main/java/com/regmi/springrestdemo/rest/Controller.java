package com.regmi.springrestdemo.rest;

import com.regmi.springrestdemo.entity.Product;
import com.regmi.springrestdemo.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    private ProductsService productsService;

    @Autowired
    public Controller(ProductsService productService) {
        this.productsService = productService;
    }

    @GetMapping("/products")
    public List<Product> getProducts(){
        return productsService.getProducts();
    }
    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable int id){
        if(productsService.getProduct(id) == null){
            throw new RuntimeException("Product with id - "+id+" :not found.");
        }
        return productsService.getProduct(id);
    }
    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product){
        product.setId(0);
        productsService.save(product);
        return product;
    }
    @PutMapping("/products")
    public Product updateProduct(@RequestBody Product product){
        productsService.save(product);

        return product;
    }
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable int id){
        if(productsService.getProduct(id) == null){
            throw new RuntimeException("Product with id - "+id+" :not found.");
        }else{
            productsService.deleteProduct(id);
        }

    }
}
