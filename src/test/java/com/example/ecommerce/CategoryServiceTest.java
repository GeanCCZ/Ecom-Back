package com.example.ecommerce;

import com.example.ecommerce.adapters.Adapter;
import com.example.ecommerce.domain.dto.CategoryDTO;
import com.example.ecommerce.domain.entities.Category;
import com.example.ecommerce.repository.CRUDRepository;
import com.example.ecommerce.repository.custom.CategoryRepository;
import com.example.ecommerce.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
public class CategoryServiceTest {

    @InjectMocks
    private CategoryService categoryService;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private CRUDRepository<Category, UUID> repository;

    @Mock
    private Adapter<Category, CategoryDTO> categoryAdapter;

    @Test
    public void testCategoryCreate(){

        CategoryDTO categoryDTO = new CategoryDTO(null,"Eletricidade",null);
        Category newCategory = new Category();

        newCategory.setDisplayName(categoryDTO.displayName());
        newCategory.setProductList(categoryDTO.productList());

        when(this.categoryAdapter.fromDto(any(CategoryDTO.class))).thenReturn(newCategory);
        when(this.repository.save(any(Category.class))).thenReturn(newCategory);

        this.categoryService.create(categoryDTO);

        verify(this.repository).save(newCategory);
        verify(this.categoryAdapter).fromEntity(newCategory);

        assertEquals(categoryDTO.displayName(), newCategory.getDisplayName());
        assertEquals(categoryDTO.productList(), newCategory.getProductList());

    }

    @Test
    public void testCategoryUpdate(){
        CategoryDTO categoryDTO = new CategoryDTO(null,"Eletricidade",null);
        Category newCategory = new Category();

        newCategory.setDisplayName(categoryDTO.displayName());
        newCategory.setProductList(categoryDTO.productList());

        when(this.categoryAdapter.fromDto(any(CategoryDTO.class))).thenReturn(newCategory);
        when(this.repository.save(any(Category.class))).thenReturn(newCategory);

        CategoryDTO createdCategory = this.categoryService.create(categoryDTO);

        when(this.repository.findById(createdCategory.id())).thenReturn(java.util.Optional.of(newCategory));

        CategoryDTO updatedCategory = this.categoryService.update(createdCategory.id(),categoryDTO);
    }
}
