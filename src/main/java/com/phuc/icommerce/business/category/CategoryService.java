package com.phuc.icommerce.business.category;

import com.phuc.icommerce.data.entity.product.Category;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    Category create(Category category);
}
