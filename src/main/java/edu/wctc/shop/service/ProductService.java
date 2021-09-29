package edu.wctc.shop.service;

import edu.wctc.shop.entity.Product;

import java.util.List;

public interface ProductService {
    Product getProduct(int productId);
    List<Product> getProductList();
    void saveProduct(Product product);

    void deleteProduct(int id);
}
