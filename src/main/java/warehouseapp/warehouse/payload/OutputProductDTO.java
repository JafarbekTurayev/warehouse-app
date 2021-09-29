package warehouseapp.warehouse.payload;

import lombok.Data;

@Data
public class OutputProductDTO {
    private Integer productId;
    private double amount,price;
}
