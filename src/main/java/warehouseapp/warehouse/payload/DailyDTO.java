package warehouseapp.warehouse.payload;

import lombok.Data;

import java.util.Date;

@Data
public class DailyDTO {
    private double amount;
    private double sum;
    private String productName;
}
