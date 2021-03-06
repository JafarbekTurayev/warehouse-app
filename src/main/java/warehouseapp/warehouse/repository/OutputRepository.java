package warehouseapp.warehouse.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import warehouseapp.warehouse.entity.Currency;
import warehouseapp.warehouse.entity.Output;

import java.util.UUID;

public interface OutputRepository extends JpaRepository<Output, UUID> {
}
