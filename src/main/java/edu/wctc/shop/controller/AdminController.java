package edu.wctc.shop.controller;

import edu.wctc.shop.entity.Product;
import edu.wctc.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
public class AdminController {
    private ProductService productService;


    @Autowired
    public AdminController(ProductService ps) {
        this.productService = ps;
    }

    @RequestMapping("/admin/products")
    public String showProductList(Model model) {
        model.addAttribute("pageTitle", "Our Products");
        model.addAttribute("productList", productService.getProductList());

        return "admin-product-list";
    }

    @RequestMapping("/admin/product/{product_id}")
    public String showProduct(Model model, @PathVariable int product_id) {

        Product product = productService.getProduct(product_id);
        model.addAttribute("pageTitle", product.getName());
        model.addAttribute("product", product);

        return "admin-product";
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

    @PostMapping("/admin/product/create")
    public String updateProduct(
            Model model,
            @Valid @ModelAttribute("product")Product product,
            BindingResult bindingResult)
    {

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);
        } else {
            System.out.println(product.getPrice());
            System.out.println(product.getStock());

            productService.saveProduct(product);
        }

        model.addAttribute("pageTitle", "Admin Product Mode");
        model.addAttribute("productList", productService.getProductList());
        return "admin-product-list";
    }

    @RequestMapping("/admin/product/{product_id}/delete")
    public RedirectView deleteProduct(Model model,
                                      @PathVariable int product_id) {


        productService.deleteProduct(product_id);

        model.addAttribute("pageTitle", "Thank You!");
        model.addAttribute("ProductList", productService.getProductList());

        return new RedirectView("/admin/products");

    }
}

