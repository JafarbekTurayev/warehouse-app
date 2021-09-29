package warehouseapp.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import warehouseapp.warehouse.entity.*;
import warehouseapp.warehouse.payload.ApiResponse;
import warehouseapp.warehouse.payload.ProductDTO;
import warehouseapp.warehouse.repository.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    MeasurementRepository measurementRepository;
    @Autowired
    AttachmentContentRepository attachmentContentRepository;
    @Autowired
    AttachmentRepository attachmentRepository;

    public ApiResponse save(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setCode(UUID.randomUUID().toString());

        //if bn tekshirish kk
        Optional<Category> categoryOptional = categoryRepository.findById(productDTO.getCategoryId());
        product.setCategory(categoryOptional.get());

        Optional<Measurement> optionalMeasurement = measurementRepository.findById(productDTO.getMeasurementId());
        product.setMeasurement(optionalMeasurement.get());

//        List<Attachment> allById = attachmentRepository.findAllById(productDTO.getAttachmentIds());
//        product.setAttachments(allById);

        productRepository.save(product);
        return new ApiResponse("Save", true);
    }

    public ApiResponse getByCatId(Integer catId) {
        return new ApiResponse("Mana", true, productRepository.findAllByCategoryId(catId));
    }

//    public ApiResponse searchByName(String name) {
//        return new ApiResponse("Mana", true, productRepository.findByNameLike("%" + name + "%"));
//    }


}
