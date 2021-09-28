package warehouseapp.warehouse.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import warehouseapp.warehouse.entity.Currency;

public interface ClientRepository extends JpaRepository<Currency, Integer> {
}
