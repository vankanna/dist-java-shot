package edu.wctc.shop.repo;

import edu.wctc.shop.entity.Product;
import org.springframework.data.repository.CrudRepository;

// gives access to the built in crud functionality of the spring framework
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
