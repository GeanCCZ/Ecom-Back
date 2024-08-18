import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.ecommerce.domain.dto.SubCategoryDTO;
import com.example.ecommerce.service.SubCategoryService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SubCategoryServiceTest {

    @InjectMocks
    private SubCategoryService subCategoryService;

    @Test
    public void testSubCategoryCreate(){
         SubCategoryDTO newSubCategory = new SubCategoryDTO(null, "SubCategory", null);

         SubCategoryDTO createdSubCategory = this.subCategoryService.create(newSubCategory);

        assertEquals(newSubCategory.displayName(), createdSubCategory.displayName());

         assertEquals(newSubCategory.productList(), createdSubCategory.productList());

    }

    @Test
    public void testSubCategoryUpdate(){
         SubCategoryDTO newSubCategory = new SubCategoryDTO(null, "SubCategory", null);

         SubCategoryDTO createdSubCategory = this.subCategoryService.create(newSubCategory);

         SubCategoryDTO updateSubCategoryDTO = new SubCategoryDTO(createdSubCategory.id(), "SubCategory", null);

         SubCategoryDTO updatedSubCategory = this.subCategoryService.update(createdSubCategory.id(), updateSubCategoryDTO);

        assertEquals(updateSubCategoryDTO.displayName(), updatedSubCategory.displayName());

         assertEquals(updateSubCategoryDTO.productList(), updatedSubCategory.productList());
    }

}
