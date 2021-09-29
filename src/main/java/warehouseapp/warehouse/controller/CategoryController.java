package warehouseapp.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import warehouseapp.warehouse.entity.Category;
import warehouseapp.warehouse.payload.ApiResponse;
import warehouseapp.warehouse.payload.CategoryDTO;
import warehouseapp.warehouse.repository.CategoryRepository;
import warehouseapp.warehouse.service.CategoryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CategoryService categoryService;

    @PostMapping("/add")
    public ApiResponse save(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.saveCategory(categoryDTO);
    }

    @GetMapping("/list")
    public ApiResponse getAll() {
        return new ApiResponse("Mana list", true, categoryRepository.findAll());
    }

    @GetMapping("/{id}")
    public ApiResponse getOne(@PathVariable Integer id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (!optionalCategory.isPresent()) return new ApiResponse("NOT", false);
        return new ApiResponse("Mana", true, optionalCategory.get());
    }

    //eng katta Parentlar
    @GetMapping("/parentList")
    public ApiResponse getParents() {
        return categoryService.getParents();
    }

    //Parent Id {id} bolalari
    @GetMapping("/byParentId/{id}")
    public ApiResponse getByParentId(@PathVariable Integer id) {
        return categoryService.getByParentId(id);
    }

    @PutMapping("/edit/{id}")
    public ApiResponse edit(@PathVariable Integer id, @RequestBody CategoryDTO categoryDTO) {
        return categoryService.edit(id, categoryDTO);
    }

    @DeleteMapping("/{id}")
    public ApiResponse delete(@PathVariable Integer id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
        }
        return new ApiResponse("Saved!", true);
    }

}
