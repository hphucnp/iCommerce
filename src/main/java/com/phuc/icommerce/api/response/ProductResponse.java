package com.phuc.icommerce.api.response;

import com.phuc.icommerce.data.entity.product.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {
    private Long id;
    private String name;
    private Long category;
    private Long brand;
    private String color;
    private Long cart;

    public static ProductResponse fromEntity(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setBrand(product.getBrand().getId());
        productResponse.setCategory(product.getCategory().getId());
        productResponse.setColor(product.getColor()!=null?product.getColor().toString():null);
        return productResponse;
    }
}
