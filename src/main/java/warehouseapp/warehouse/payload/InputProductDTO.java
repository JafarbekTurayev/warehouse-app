package warehouseapp.warehouse.payload;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class InputProductDTO {
    private Integer productId;
    private double price,amount;
    private Date expireDate;
}
