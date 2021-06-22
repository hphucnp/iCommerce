package com.phuc.icommerce.api.controller;

import com.phuc.icommerce.api.response.ProductResponse;
import com.phuc.icommerce.business.product.ProductService;
import com.phuc.icommerce.data.entity.product.Product;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping(value = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Product Rest API", description = "Product")
@RequiredArgsConstructor

public class ProductController {

    private final ProductService productService;

    @GetMapping(value = "/{id}")
    public ProductResponse get(@PathVariable Long id) {
        Product product = this.productService.findById(id);
        return ProductResponse.fromEntity(product);
    }

    @GetMapping
    public Page<ProductResponse> get(@PageableDefault Pageable pageable,
                                     HttpServletRequest request) {
        Map<String, String[]> filters = request.getParameterMap();
        System.out.println(filters.toString());
        Page<Product> products = productService.getList(filters, pageable);
        return products.map(ProductResponse::fromEntity);
    }

}
