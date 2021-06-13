package com.phuc.icommerce.api.controller;

import com.phuc.icommerce.api.response.CategoryRequest;
import com.phuc.icommerce.api.response.CategoryResponse;
import com.phuc.icommerce.business.category.CategoryService;
import com.phuc.icommerce.data.entity.product.Category;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/category", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Category Rest API", description = "Category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping
    public List<CategoryResponse> getAll() {
        List<Category> categories = this.categoryService.getAll();
        return categories.stream().map(CategoryResponse::fromEntity).collect(Collectors.toList());
    }

    @PostMapping
    public CategoryResponse create(@RequestBody CategoryRequest categoryRequest) {
        Category category = CategoryRequest.toEntity(categoryRequest);
        return CategoryResponse.fromEntity(this.categoryService.create(category));
    }
}
