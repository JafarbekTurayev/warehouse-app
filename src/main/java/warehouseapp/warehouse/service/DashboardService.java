package warehouseapp.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import warehouseapp.warehouse.entity.Input;
import warehouseapp.warehouse.entity.InputProduct;
import warehouseapp.warehouse.payload.ApiResponse;
import warehouseapp.warehouse.payload.DailyDTO;
import warehouseapp.warehouse.repository.InputProductRepository;
import warehouseapp.warehouse.repository.InputRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DashboardService {
    @Autowired
    InputRepository inputRepository;
    @Autowired
    InputProductRepository inputProductRepository;

    public ApiResponse getDaily(String date) throws ParseException {
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        List<DailyDTO> dailyDTOList = new ArrayList<>();
        List<Input> allByDate = inputRepository.findAllByDate(date1);
        for (Input input : allByDate) {
            List<InputProduct> allByInputId = inputProductRepository.findAllByInputId(input.getId());
            for (InputProduct inputProduct : allByInputId) {
                DailyDTO dailyDTO = new DailyDTO();
                dailyDTO.setProductName(inputProduct.getProduct().getName());
                dailyDTO.setAmount(inputProduct.getAmount());
                dailyDTO.setSum(inputProduct.getAmount() * inputProduct.getPrice());
                dailyDTOList.add(dailyDTO);
            }
        }
        return new ApiResponse("Mana", true, dailyDTOList);
    }


    public ApiResponse notification(String date) throws ParseException {
        Long currentTime = new SimpleDateFormat("yyyy-MM-dd").parse(date).getTime();

        Date mustDate = new Date(currentTime + (86400 * 1000 * 3));
        List<InputProduct> dateBefore = inputProductRepository.findAllByExpireDateBefore(mustDate);

        return new ApiResponse("Mana", true, dateBefore);

    }
}
