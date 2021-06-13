package com.phuc.icommerce.api.response;

import com.phuc.icommerce.data.entity.product.Category;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoryResponse {
    private Long id;
    private String name;
    public static CategoryResponse fromEntity(Category category) {
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setId(category.getId());
        categoryResponse.setName(category.getName());
        return categoryResponse;
    }
}
