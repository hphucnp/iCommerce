package com.phuc.icommerce.business.category;

import com.phuc.icommerce.data.entity.product.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    Category create(Category category);
}
