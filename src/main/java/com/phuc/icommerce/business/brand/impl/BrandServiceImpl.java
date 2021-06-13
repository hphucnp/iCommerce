package com.phuc.icommerce.business.brand.impl;

import com.phuc.icommerce.business.brand.BrandService;
import com.phuc.icommerce.data.entity.product.Brand;
import com.phuc.icommerce.data.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    @Override
    public List<Brand> getAll() {
        return brandRepository.findAll();
    }

    @Override
    @Transactional
    public Brand create(Brand brand) {
        return brandRepository.save(brand);
    }
}
