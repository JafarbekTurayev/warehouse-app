package warehouseapp.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import warehouseapp.warehouse.entity.Category;
import warehouseapp.warehouse.payload.ApiResponse;
import warehouseapp.warehouse.payload.CategoryDTO;
import warehouseapp.warehouse.repository.CategoryRepository;
import warehouseapp.warehouse.service.CategoryService;

import java.util.List;

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


}
