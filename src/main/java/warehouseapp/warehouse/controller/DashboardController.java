package warehouseapp.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import warehouseapp.warehouse.payload.ApiResponse;
import warehouseapp.warehouse.payload.DailyDTO;
import warehouseapp.warehouse.service.DashboardService;

import java.text.ParseException;
import java.util.Date;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {
//    Kunlik kirim bo’lgan mahsulotlar (qiymati, umumiy summasi)

    @Autowired
    DashboardService dashboardService;

    @GetMapping("/daily")
    public ApiResponse getDailyInputProduct(@RequestParam String date) throws ParseException {
        return dashboardService.getDaily(date);
    }

//    @GetMapping("/notification")
//    public ApiResponse getNotification(@RequestParam String date) throws ParseException {
//        return dashboardService.notification(date);
//    }
}
