package warehouseapp.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import warehouseapp.warehouse.payload.ApiResponse;
import warehouseapp.warehouse.payload.ProductDTO;
import warehouseapp.warehouse.repository.CategoryRepository;
import warehouseapp.warehouse.repository.ProductRepository;
import warehouseapp.warehouse.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductService productService;

    @PostMapping
    public ApiResponse save(@RequestBody ProductDTO productDTO) {
        return productService.save(productDTO);
    }

//    @GetMapping("/search")
//    public ApiResponse searchByName(@RequestParam String name) {
//        return productService.searchByName(name);
//    }

    @GetMapping("/{catId}")
    public ApiResponse getByCatId(@PathVariable Integer catId) {
        return productService.getByCatId(catId);
    }



}
