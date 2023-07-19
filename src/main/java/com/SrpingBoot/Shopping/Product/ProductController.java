package com.SrpingBoot.Shopping.Product;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping("")
    public String productIndex() {
        return "products/index";
    }

    @GetMapping("/new")
    public String getProduct(Model model) {
        model.addAttribute("createForm", new ProductDto.CreateProductRequest());
        return "products/createForm";
    }

    @PostMapping("/new")
    public String saveProduct(@ModelAttribute("createForm") @Valid ProductDto.CreateProductRequest request, Model model) {
        Long id = productService.join(request);
        Optional<Product> product=productService.findById(id);
        model.addAttribute("product", product.get());
        return "products/createResult";
    }

    @GetMapping("/all")
    public String findAll(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "products/allProducts";
    }



    @GetMapping("/details/{id}")
    public String getProductDetails(@PathVariable("id") Long id, Model model) {
        Optional<Product> product = productService.findById(id);
        model.addAttribute("product", product.orElse(null));
        return "products/detailResult";
    }

}
