package warehouseapp.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import warehouseapp.warehouse.entity.Category;
import warehouseapp.warehouse.payload.ApiResponse;
import warehouseapp.warehouse.payload.CategoryDTO;
import warehouseapp.warehouse.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public ApiResponse saveCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        if (categoryDTO.getParentId() != null) {
            Optional<Category> optionalCategory = categoryRepository.findById(categoryDTO.getParentId());
            category.setParentCategory(optionalCategory.get());
        } else {
            category.setParentCategory(null);
        }
        categoryRepository.save(category);
        return new ApiResponse("Saved!", true);
    }

    public ApiResponse getParents() {
        List<Category> categoryNull = categoryRepository.findAllByParentCategoryIsNull();
        return new ApiResponse("Mana", true, categoryNull);
    }

    public ApiResponse getByParentId(Integer id) {
        List<Category> allByParentCategoryId = categoryRepository.findAllByParentCategoryId(id);
        return new ApiResponse("Mana", true, allByParentCategoryId);
    }
}
