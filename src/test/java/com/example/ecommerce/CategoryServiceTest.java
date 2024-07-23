package com.example.ecommerce;

import com.example.ecommerce.domain.dto.CategoryDTO;
import com.example.ecommerce.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CategoryServiceTest {

    @InjectMocks
    private CategoryService categoryService;

    @Test
    public void testCategoryCreate(){

        CategoryDTO newCategory = new CategoryDTO(null,"Eletricidade",null);

        CategoryDTO createdCategory = this.categoryService.create(newCategory);

        assertEquals(newCategory.display_name(), createdCategory.display_name());
        assertEquals(newCategory.productList(), createdCategory.productList());

    }

    @Test
    public void testCategoryUpdate(){
        CategoryDTO newCategory = new CategoryDTO(null,"Eletricidade",null);

        CategoryDTO createdCategory = this.categoryService.create(newCategory);

        CategoryDTO updateCategoryDTO = new CategoryDTO(createdCategory.id(),"Frutifero",null);

        CategoryDTO updatedCategory = this.categoryService.update(createdCategory.id(), updateCategoryDTO);

        assertEquals(updateCategoryDTO.display_name(), updatedCategory.display_name());
        assertEquals(updateCategoryDTO.productList(), updatedCategory.productList());
    }
}
