package warehouseapp.warehouse.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import warehouseapp.warehouse.entity.Product;
import warehouseapp.warehouse.entity.User;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
