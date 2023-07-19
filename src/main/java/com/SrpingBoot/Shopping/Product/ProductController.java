package com.SrpingBoot.Shopping.Product;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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


    @GetMapping("/details/{id}")
    public String getProductDetails(@PathVariable("id") Long id, Model model) {
        Optional<Product> product = productService.findById(id);
        model.addAttribute("product", product.orElse(null));
        return "products/detailResult";
    }

    @GetMapping("/all")
    public String productList(Model model, @PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Product> list = productService.productList(pageable);
        int nowPage = list.getNumber() + 1; // 현재 페이지 번호
        int startPage = Math.max(nowPage - 4, 1); // 시작 페이지 번호
        int endPage = Math.min(nowPage + 4, list.getTotalPages()); // 끝 페이지 번호
        model.addAttribute("products", list);
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        return "products/allProducts";
    }

}
