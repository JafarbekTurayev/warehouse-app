package warehouseapp.warehouse.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import warehouseapp.warehouse.entity.Currency;
import warehouseapp.warehouse.entity.OutputProduct;
import warehouseapp.warehouse.projection.OutputProductProjection;

import java.util.List;
import java.util.UUID;

public interface OutputProductRepository extends JpaRepository<OutputProduct, UUID> {

    List<OutputProductProjection> findAllByOutputId(UUID id);
}
