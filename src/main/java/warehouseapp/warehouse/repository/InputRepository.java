package warehouseapp.warehouse.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import warehouseapp.warehouse.entity.Currency;
import warehouseapp.warehouse.entity.Input;

import java.util.UUID;

public interface InputRepository extends JpaRepository<Input, UUID> {
}
