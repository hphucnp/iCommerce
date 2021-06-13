package com.phuc.icommerce.api.controller;

import com.phuc.icommerce.api.response.BrandRequest;
import com.phuc.icommerce.api.response.BrandResponse;
import com.phuc.icommerce.business.brand.BrandService;
import com.phuc.icommerce.data.entity.product.Brand;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/brand", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Brand Rest API", description = "Brand")
@RequiredArgsConstructor
public class BrandController {
    private final BrandService brandService;
    @GetMapping
    public List<BrandResponse> getAll() {
        List<Brand> brands = this.brandService.getAll();
        return brands.stream().map(BrandResponse::fromEntity).collect(Collectors.toList());
    }

    @PostMapping
    public BrandResponse create(@RequestBody BrandRequest brandRequest) {
        Brand brand = BrandRequest.toEntity(brandRequest);
        return BrandResponse.fromEntity(this.brandService.create(brand));
    }
}
