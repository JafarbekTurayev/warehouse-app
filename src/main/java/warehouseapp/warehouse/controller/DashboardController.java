package warehouseapp.warehouse.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import warehouseapp.warehouse.entity.InputProduct;
import warehouseapp.warehouse.payload.*;
import warehouseapp.warehouse.repository.InputProductRepository;
import warehouseapp.warehouse.service.DashboardService;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/dashboard")
public class DashboardController {

//    Kunlik kirim bo’lgan mahsulotlar (qiymati, umumiy summasi)

    final DashboardService dashboardService;
    final InputProductRepository inputProductRepository;


    @GetMapping("/daily")
    public HttpEntity<?> getDailyInputProduct(@RequestParam String date) throws ParseException {
        return ResponseEntity.ok(dashboardService.getDaily(date));
    }

//    @GetMapping("/notification")
//    public ApiResponse getNotification(@RequestParam String date) throws ParseException {
//        return dashboardService.notification(date);
//    }

    @GetMapping("/leftover/{id}")
    public HttpEntity<?> getLeftOver(@PathVariable Integer id) {
//        List<InputProduct> allByProductId = inputProductRepository.findAllByProductId(id);
//        double sum = 0;
//        for (InputProduct inputProduct : allByProductId) {
//            sum += inputProduct.getAmount();
//        }
//        return ResponseEntity.ok(inputProductRepository.countAllByProductId(id));

        return null;
    }


    @GetMapping("/some")
    public HttpEntity<?> getAllAmount(){
        List<InputDTOProduct> inputDTOProducts= inputProductRepository.getAllProductAmountSum();
        return ResponseEntity.ok(inputDTOProducts);
    }
}
