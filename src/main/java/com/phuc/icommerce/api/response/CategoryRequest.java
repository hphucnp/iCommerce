package com.phuc.icommerce.api.response;

import com.phuc.icommerce.data.entity.product.Category;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class CategoryRequest {
    @NonNull
    private String name;

    public static Category toEntity(CategoryRequest categoryRequest){
        Category category = new Category();
        category.setName(categoryRequest.getName());
        return category;
    }

}
