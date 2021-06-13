package com.phuc.icommerce.api.response;

import com.phuc.icommerce.data.entity.product.Brand;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrandResponse {
    private Long id;
    private String name;

    public static BrandResponse fromEntity(Brand brand) {
        BrandResponse brandResponse = new BrandResponse();
        brandResponse.setId(brand.getId());
        brandResponse.setName(brand.getName());
        return brandResponse;
    }
}
