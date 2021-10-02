package warehouseapp.warehouse.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import warehouseapp.warehouse.entity.Currency;
import warehouseapp.warehouse.entity.OutputProduct;

import java.util.UUID;

public interface OutputProductRepository extends JpaRepository<OutputProduct, UUID> {
}
