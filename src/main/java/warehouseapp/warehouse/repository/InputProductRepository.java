package warehouseapp.warehouse.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import warehouseapp.warehouse.entity.Currency;
import warehouseapp.warehouse.entity.InputProduct;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface InputProductRepository extends JpaRepository<InputProduct, UUID> {
    List<InputProduct> findAllByInputId(UUID id);

    List<InputProduct> findAllByExpireDateBefore(Date date);

}
