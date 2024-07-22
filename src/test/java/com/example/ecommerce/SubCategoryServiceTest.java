package com.example.ecommerce;

import com.example.ecommerce.domain.dto.SubCategoryDTO;
import com.example.ecommerce.service.SubCategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SubCategoryServiceTest {

    @Autowired
    private SubCategoryService subCategoryService;

    @Test
    public void testSubCategoryCreate(){
         SubCategoryDTO newSubCategory = new SubCategoryDTO(null, "SubCategory", null);

         SubCategoryDTO createdSubCategory = this.subCategoryService.create(newSubCategory);

         assertEquals(newSubCategory.display_name(), createdSubCategory.display_name());

         assertEquals(newSubCategory.productList(), createdSubCategory.productList());

    }

    @Test
    public void testSubCategoryUpdate(){
         SubCategoryDTO newSubCategory = new SubCategoryDTO(null, "SubCategory", null);

         SubCategoryDTO createdSubCategory = this.subCategoryService.create(newSubCategory);

         SubCategoryDTO updateSubCategoryDTO = new SubCategoryDTO(createdSubCategory.id(), "SubCategory", null);

         SubCategoryDTO updatedSubCategory = this.subCategoryService.update(createdSubCategory.id(), updateSubCategoryDTO);

         assertEquals(updateSubCategoryDTO.display_name(), updatedSubCategory.display_name());

         assertEquals(updateSubCategoryDTO.productList(), updatedSubCategory.productList());
    }

}
