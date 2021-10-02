package warehouseapp.warehouse.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import warehouseapp.warehouse.entity.Currency;
import warehouseapp.warehouse.entity.InputProduct;
import warehouseapp.warehouse.payload.InputDTOProduct;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface InputProductRepository extends JpaRepository<InputProduct, UUID> {
    List<InputProduct> findAllByInputId(UUID id);

    List<InputProduct> findAllByExpireDateBefore(Date date);

    //pId=3 shuncha row bor deydi?
    long countAllByProductId(Integer pId);

    @Query(value = "select (select sum(amount) from input_product where product_id=:pId) - (select sum(amount) from output_product where product_id=:pId)", nativeQuery = true)
    public Double getSumInput(Integer pId);

    List<InputProduct> findAllByProductId(Integer pId);

    @Query(value = "select sum(i.amount), p.name\n" +
            "from input_product i\n" +
            "         join product p on p.id = i.product_id\n" +
            "group by p.name", nativeQuery = true)
    public List<InputDTOProduct> getAllProductAmountSum();

}
