package com.example.ecommerce;

import com.example.ecommerce.domain.dto.CategoryDTO;
import com.example.ecommerce.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void testCategoryCreate(){

        CategoryDTO newCategory = new CategoryDTO(null,"Eletricidade",null);

        CategoryDTO createdCategory = this.categoryService.create(newCategory);

        CategoryDTO expectedCategory = new CategoryDTO(createdCategory.id(), newCategory.display_name(), newCategory.productList());

        assertEquals(expectedCategory,createdCategory);

    }

    @Test
    public void testCategoryUpdate(){
        CategoryDTO newCategory = new CategoryDTO(null,"Eletricidade",null);

        CategoryDTO createdCategory = this.categoryService.create(newCategory);

        CategoryDTO updateCategoryDTO = new CategoryDTO(createdCategory.id(),"Frutifero",null);

        CategoryDTO updatedCategory = this.categoryService.update(createdCategory.id(), updateCategoryDTO);

        CategoryDTO expectedCategory = new CategoryDTO(updatedCategory.id(), updateCategoryDTO.display_name(), updateCategoryDTO.productList());

        assertEquals(expectedCategory,updatedCategory);
    }
}
