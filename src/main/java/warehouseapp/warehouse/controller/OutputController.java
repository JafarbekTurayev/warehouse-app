package warehouseapp.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import warehouseapp.warehouse.entity.Output;
import warehouseapp.warehouse.payload.ApiResponse;
import warehouseapp.warehouse.payload.OutputDTO;
import warehouseapp.warehouse.projection.OutputProductProjection;
import warehouseapp.warehouse.repository.OutputProductRepository;
import warehouseapp.warehouse.repository.OutputRepository;
import warehouseapp.warehouse.service.OutputService;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/output")
public class OutputController {

    @Autowired
    OutputService outputService;

    @Autowired
    OutputRepository outputRepository;

    @Autowired
    OutputProductRepository outputProductRepository;

    @PostMapping("/add")
    public ApiResponse save(@RequestBody OutputDTO outputDTO) {
        return outputService.addOutput(outputDTO);
    }

    @GetMapping("/list")
    public List<Output>outputs(){
        return outputRepository.findAll();
    }

    @PutMapping("/edit/{id}")
    public ApiResponse edit(@PathVariable UUID id, @RequestBody OutputDTO outputDTO){
        return outputService.edit(outputDTO,id);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse delete(@PathVariable UUID id){
        return outputService.delete(id);
    }

    @GetMapping("/byId/{id}")
    public ApiResponse byId(@PathVariable UUID id){
      return outputService.byId(id);
    }


}

