package edu.wctc.shop.controller;

import edu.wctc.shop.entity.Product;
import edu.wctc.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class SaleController {
    private ProductService productService;


    @Autowired
    public SaleController(ProductService ps) {
        this.productService = ps;
    }

    @RequestMapping("/sales")
    public String showProductList(Model model) {
        model.addAttribute("pageTitle", "Sale Summary");
        model.addAttribute("productList", productService.getProductList());

        return "sale-summary";
    }

    @RequestMapping("/product/{product_id}")
    public String showProduct(Model model, @PathVariable int product_id) {

        Product product = productService.getProduct(product_id);
        model.addAttribute("pageTitle", product.getName());
        model.addAttribute("product", product);

        return "product";
    }

    @PostMapping("/admin/product/{product_id}/update")
    public String updateProduct(
            Model model,
            @PathVariable int product_id,
            @Valid @ModelAttribute("product")Product product,
            BindingResult bindingResult)
    {

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);
        } else {
            Product oldProduct = productService.getProduct(product_id);
            oldProduct.setName(product.getName());
            oldProduct.setDescription(product.getDescription());
            oldProduct.setPrice(product.getPrice());
            oldProduct.setStock(product.getStock());
            productService.saveProduct(oldProduct);
        }

        model.addAttribute("pageTitle", "Admin Product Mode");
        model.addAttribute("product", productService.getProduct(product_id));
        return "admin-product";
    }
}
