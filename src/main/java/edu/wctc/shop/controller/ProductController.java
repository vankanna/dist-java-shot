package edu.wctc.shop.controller;

import edu.wctc.shop.entity.Product;
import edu.wctc.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping("product/sale-summary")
    public String orderSummary(Model model, @RequestParam String[] productIds)
    {
        List<Product> productList = new ArrayList<Product>();
        double totalCost = 0;

        for (String id: productIds) {
            Product product = productService.getProduct(Integer.parseInt(id));
            productList.add(product);
            totalCost += product.getPrice();
            int stock = product.getStock();
            product.setStock(stock - 1);
            productService.saveProduct(product);
        }
        model.addAttribute("pageTitle", "Order Summary");
        model.addAttribute("productList", productList);
        model.addAttribute("totalCost", totalCost);

        return "sale-summary";

    }
}
