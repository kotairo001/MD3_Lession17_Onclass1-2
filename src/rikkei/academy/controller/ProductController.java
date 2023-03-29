package rikkei.academy.controller;

import rikkei.academy.model.Product;
import rikkei.academy.service.IProductService;
import rikkei.academy.service.ProductServiceIMPL;

import java.util.List;

public class ProductController {
    IProductService productService = new ProductServiceIMPL();
    public List<Product> getListProduct(){
        return productService.findAll();

    }
    public void addProduct(Product product){
        productService.save(product);
    }
    public Product searchProduct(int id){
        return productService.findById(id);
    }
    public Product detailProduct(int id){
        return productService.findById(id);
    }

    public void updateProduct(Product product){
        productService.save(product);
    }
    public void delete(int id){
        productService.delete(id);
    }
}
