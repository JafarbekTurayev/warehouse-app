package warehouseapp.warehouse.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import warehouseapp.warehouse.entity.Currency;
import warehouseapp.warehouse.entity.InputProduct;

import java.util.UUID;

public interface InputProductRepository extends JpaRepository<InputProduct, UUID> {
}
