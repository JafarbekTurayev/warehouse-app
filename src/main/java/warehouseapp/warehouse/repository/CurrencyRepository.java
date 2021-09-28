package warehouseapp.warehouse.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import warehouseapp.warehouse.entity.Category;
import warehouseapp.warehouse.entity.Currency;

public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
}
