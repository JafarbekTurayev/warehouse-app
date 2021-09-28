package warehouseapp.warehouse.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import warehouseapp.warehouse.entity.Currency;

import java.util.UUID;

public interface OutputProductRepository extends JpaRepository<Currency, UUID> {
}
