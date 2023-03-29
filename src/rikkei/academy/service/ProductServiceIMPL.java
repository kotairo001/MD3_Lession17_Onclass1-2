package rikkei.academy.service;

import rikkei.academy.config.Config;
import rikkei.academy.model.Product;

import java.util.List;

public class ProductServiceIMPL implements IProductService {

    List<Product> productList = new Config<Product>().readFromFile(Config.PATH_PRODUCT);

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        if (findById(product.getProductId()) == null) {
            productList.add(product);
        } else {
            int index = productList.indexOf(findById(product.getProductId()));
            productList.set(index, product);
        }
        new Config<Product>().writeToFile(Config.PATH_PRODUCT, productList);
    }

    @Override
    public Product findById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductId() == id) {
                return productList.get(i);
            }
        }
        return null;
    }

    @Override
    public void delete(int id) {
        productList.remove(productList.indexOf(findById(id)));
        new Config<Product>().writeToFile(Config.PATH_PRODUCT, productList);
    }


}
