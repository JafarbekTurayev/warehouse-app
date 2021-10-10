package warehouseapp.warehouse.payload;

import lombok.Data;
import warehouseapp.warehouse.entity.Output;
import warehouseapp.warehouse.entity.OutputProduct;

import java.util.Date;
import java.util.List;

@Data
public class OutputDTO {
    private Date date;
    private Integer warehouseId, clientId, currencyId;
    private List<OutputProductDTO> outputProductDTOList;
}