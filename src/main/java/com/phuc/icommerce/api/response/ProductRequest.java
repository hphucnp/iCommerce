package com.phuc.icommerce.api.response;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@NonNull
public class ProductRequest {
    private String name;
    private Long category;
    private Long brand;
    private String color;

//    public static Product toEntity(ProductRequest productRequest) {
//        Product product = new Product();
//
//        product.setName(productRequest.getName());
//
//        product.setCategory(productRequest.getCategory());
//        Brand brand = new Brand({id: productRequest.getBrand()})
//        productResponse.setBrand(product.getBrand().getId());
//        productResponse.setCategory(product.getCategory().getId());
//        productResponse.setColor(product.getColor().toString());
//        return productResponse;
//    }
}
