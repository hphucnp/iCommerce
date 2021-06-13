package com.phuc.icommerce.api.response;

import com.phuc.icommerce.data.entity.product.Brand;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Setter
@Getter
public class BrandRequest {
    @NonNull
    private String name;

    public static Brand toEntity(BrandRequest brandRequest) {
        Brand brand = new Brand();
        brand.setName(brandRequest.getName());
        return brand;
    }
}
