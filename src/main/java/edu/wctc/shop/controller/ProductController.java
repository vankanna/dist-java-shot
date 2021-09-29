package edu.wctc.shop.controller;

import edu.wctc.shop.entity.Product;
import edu.wctc.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class ProductController {
    private ProductService productService;


    @Autowired
    public ProductController(ProductService ps) {
        this.productService = ps;
    }

    @RequestMapping("/products")
    public String showProductList(Model model) {
        model.addAttribute("pageTitle", "Our Products");
        model.addAttribute("productList", productService.getProductList());

        return "product-list";
    }

    @RequestMapping("/product/{product_id}")
    public String showProduct(Model model, @PathVariable int product_id) {

        Product product = productService.getProduct(product_id);
        model.addAttribute("pageTitle", product.getName());
        model.addAttribute("product", product);

        return "product";
    }
}
