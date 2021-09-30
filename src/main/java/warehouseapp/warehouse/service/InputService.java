package warehouseapp.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import warehouseapp.warehouse.entity.*;
import warehouseapp.warehouse.payload.ApiResponse;
import warehouseapp.warehouse.payload.InputDTO;
import warehouseapp.warehouse.payload.InputProductDTO;
import warehouseapp.warehouse.repository.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class InputService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    InputRepository inputRepository;

    @Autowired
    InputProductRepository inputProductRepository;

    @Autowired
    SupplierRepository supplierRepository;

    @Autowired
    CurrencyRepository currencyRepository;

    @Autowired
    WarehouseRepository warehouseRepository;


    public ApiResponse addInput(InputDTO inputDTO) {
        Input input = new Input();
        input.setCode(UUID.randomUUID().toString());
        input.setDate(inputDTO.getDate());
        input.setFactureNumber(UUID.randomUUID().toString());

        Optional<Currency> optionalCurrency = currencyRepository.findById(inputDTO.getCurrencyId());
        if (!optionalCurrency.isPresent()) return new ApiResponse("NOT", false);
        input.setCurrency(optionalCurrency.get());


        Optional<Supplier> optionalSupplier = supplierRepository.findById(inputDTO.getSupplierId());
        if (!optionalSupplier.isPresent()) return new ApiResponse("NOT", false);
        input.setSupplier(optionalSupplier.get());


        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(inputDTO.getWarehouseId());
        if (!optionalWarehouse.isPresent()) return new ApiResponse("NOT", false);
        input.setWarehouse(optionalWarehouse.get());
        inputRepository.save(input);


        List<InputProductDTO> inputProductDTOList = inputDTO.getInputProductDTOList();

        for (InputProductDTO inputProductDTO : inputProductDTOList) {
            InputProduct inputProduct = new InputProduct();
            inputProduct.setAmount(inputProductDTO.getAmount());
            inputProduct.setPrice(inputProductDTO.getPrice());

            inputProduct.setExpireDate(inputProductDTO.getExpireDate());

            Optional<Product> optionalProduct = productRepository.findById(inputProductDTO.getProductId());
            if (!optionalProduct.isPresent()) return new ApiResponse("NOT", false);
            inputProduct.setProduct(optionalProduct.get());

            inputProduct.setInput(input);
            inputProductRepository.save(inputProduct);
        }
        return new ApiResponse("Save", true);
    }
}
