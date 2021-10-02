package warehouseapp.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import warehouseapp.warehouse.entity.Input;
import warehouseapp.warehouse.payload.ApiResponse;
import warehouseapp.warehouse.payload.InputDTO;
import warehouseapp.warehouse.repository.InputRepository;
import warehouseapp.warehouse.service.InputService;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/input")
public class InputController {
    @Autowired
    InputService inputService;
    @Autowired
    InputRepository inputRepository;

    @PostMapping("/add")
    public ApiResponse save(@RequestBody InputDTO inputDTO) throws ParseException {
        return inputService.addInput(inputDTO);
    }

    @GetMapping("/list")
    public List<Input> getAll() {
        List<Input> all = inputRepository.findAll();
        return all;
    }

}
