package com.phuc.icommerce.business.brand;


import com.phuc.icommerce.data.entity.product.Brand;

import java.util.List;

public interface BrandService {
    List<Brand> getAll();
    Brand create(Brand brand);
}

