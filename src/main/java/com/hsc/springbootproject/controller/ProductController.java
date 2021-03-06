package com.hsc.springbootproject.controller;

import java.util.List;

import com.hsc.springbootproject.product.entity.Product;
import com.hsc.springbootproject.product.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    //ProductController will talk to ProductService
    @Autowired
    private ProductService service;

    @PostMapping("/")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @PostMapping("/batch")
    public List<Product> addProducts(@RequestBody List<Product> products){
        return service.saveProducts(products);
    }

    //if there's any input that has to be passed as a request url then use @PathVariable
    @GetMapping("/")
    public List<Product> findAllProducts() {
        return service.getProducts();
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @GetMapping("/name/{name}")
    public Product findProductByName(@PathVariable String name) {
        return service.getProductByName(name);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }
}