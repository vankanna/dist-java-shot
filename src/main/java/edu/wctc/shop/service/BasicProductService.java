package edu.wctc.shop.service;

import edu.wctc.shop.entity.Product;
import edu.wctc.shop.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BasicProductService implements ProductService {
    private ProductRepository productRepository;

    @Autowired
    public BasicProductService(ProductRepository sr) {
        this.productRepository = sr;
    }

    @Override
    public Product getProduct(int productId) {
        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()) {
            return product.get();
        }
        return null;
    }

    @Override
    public List<Product> getProductList() {
        List<Product> list = new ArrayList<>();
        productRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}
