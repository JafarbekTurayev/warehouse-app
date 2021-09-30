package warehouseapp.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import warehouseapp.warehouse.entity.Currency;
import warehouseapp.warehouse.payload.ApiResponse;
import warehouseapp.warehouse.repository.CurrencyRepository;
import warehouseapp.warehouse.service.CurrencyService;

import java.util.List;

@RestController
@RequestMapping("/api/currency")
public class CurrencyController {
    @Autowired
    CurrencyRepository currencyRepository;
    @Autowired
    CurrencyService currencyService;

    @PostMapping("/add")
    public ApiResponse add(@RequestBody Currency currency) {
        return currencyService.addCurrency(currency);
    }

    @GetMapping("/list")
    public List<Currency> getAll() {
        return currencyRepository.findAll();
    }

    @GetMapping("/{id}")
    public ApiResponse getById(@PathVariable Integer id) {
        return currencyService.getById(id);
    }

    @PutMapping("/edit/{id}")
    public ApiResponse edit(@PathVariable Integer id, Currency currency) {
        return currencyService.edit(id, currency);
    }

    @DeleteMapping("/{id}")
    public ApiResponse deleted(@PathVariable Integer id) {
        if (!currencyRepository.existsById(id)) return new ApiResponse("Xatolik!", false);
        currencyRepository.deleteById(id);
        return new ApiResponse("Deleted !", true);
    }

    @GetMapping("/changeStatus/{id}")
    public ApiResponse change(@PathVariable Integer id) {
        return currencyService.changeStatus(id);
    }
}
