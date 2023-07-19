package com.SrpingBoot.Shopping.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){this.productRepository=productRepository;}

    @Transactional
    public Long join(ProductDto.CreateProductRequest request) {
        Product product = Product.builder()
                .categoryCode(request.getCategoryCode())
                .name(request.getName())
                .desc(request.getDesc())
                .price(request.getPrice())
                .stock(request.getStock())
                .build();

        Product savedProduct = productRepository.save(product);
        return savedProduct.getId();
    }


    public Optional<Product> findById(Long id) { return productRepository.findById(id); }
    public List<Product> findAll() { return productRepository.findAll(); }

    public void deleteById(Long id) { productRepository.deleteById(id); }

    public void update(Product product) { productRepository.save(product); }

    public Page<Product> productList(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
}

