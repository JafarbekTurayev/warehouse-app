package warehouseapp.warehouse.payload;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class ProductDTO {
    private String name;
    private Integer categoryId, measurementId;
    private List<UUID> attachmentIds;
}
