package warehouseapp.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import warehouseapp.warehouse.entity.*;
import warehouseapp.warehouse.payload.ApiResponse;
import warehouseapp.warehouse.payload.OutputDTO;
import warehouseapp.warehouse.payload.OutputProductDTO;
import warehouseapp.warehouse.repository.*;

import java.util.Optional;
import java.util.UUID;

@Service
public class OutputService {

    @Autowired
    OutputRepository outputRepository;

    @Autowired
    OutputProductRepository outputProductRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    WarehouseRepository warehouseRepository;

    @Autowired
    CurrencyRepository currencyRepository;

    @Autowired
    ProductRepository productRepository;

    public ApiResponse addOutput( OutputDTO outputDTO){

        Output output=new Output();
        output.setDate(outputDTO.getDate());
        output.setCode(UUID.randomUUID().toString());
        output.setFactureNumber(UUID.randomUUID().toString());

        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(outputDTO.getWarehouseId());
        if (!optionalWarehouse.isPresent()){
            return new ApiResponse("Warehouse not found",false);
        }
        output.setWarehouse(optionalWarehouse.get());


        Optional<Client> optionalClient = clientRepository.findById(outputDTO.getClientId());
        if (!optionalClient.isPresent()){
            return new ApiResponse("Client not found",false);
        }
        output.setClient(optionalClient.get());


        Optional<Currency> optionalCurrency = currencyRepository.findById(outputDTO.getCurrencyId());
        if (!optionalCurrency.isPresent()){
            return new ApiResponse("Currency not found",false);
        }
        output.setCurrency(optionalCurrency.get());
                outputRepository.save(output);

    return new ApiResponse("Saved",true);
    }

    public ApiResponse edit(OutputDTO outputDTO,UUID id) {
        Optional<Output> optionalOutput = outputRepository.findById(id);

        if (!optionalOutput.isPresent()){
            return new ApiResponse("Output not found",false);
        }

        Output output = optionalOutput.get();

        if (outputDTO.getDate()!=null){
            output.setDate(outputDTO.getDate());
        }

        if (outputDTO.getWarehouseId()!=null){
            Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(outputDTO.getWarehouseId());
            if (!optionalWarehouse.isPresent()){
                return new ApiResponse("Warehouse not found",false);
            }
            output.setWarehouse(optionalWarehouse.get());
        }

        if (outputDTO.getClientId()!=null){
            Optional<Client> optionalClient = clientRepository.findById(outputDTO.getClientId());
            if (!optionalClient.isPresent()){
                return new ApiResponse("Client not found",false);
            }
            output.setClient(optionalClient.get());
        }

        if (outputDTO.getCurrencyId()!=null){
            Optional<Currency> optionalCurrency= currencyRepository.findById(outputDTO.getCurrencyId());
            if (!optionalCurrency.isPresent()){
                return new ApiResponse("Currency not found",false);
            }
            output.setCurrency(optionalCurrency.get());
        }

        outputRepository.save(output);

        return new ApiResponse("Edited",true);

    }

    public ApiResponse delete(UUID id) {
        Optional<Output> optionalOutput = outputRepository.findById(id);

        if (!optionalOutput.isPresent()){
            return new ApiResponse("Output not found",false);
        }
        outputRepository.deleteById(id);
       return new ApiResponse("deleted",true);
    }

    public ApiResponse byId(UUID id){
        Optional<Output> optionalOutput = outputRepository.findById(id);
        if (!optionalOutput.isPresent()){
            return new ApiResponse("Not found",false);
        }
        return new ApiResponse("Found",true,optionalOutput);
    }
}
