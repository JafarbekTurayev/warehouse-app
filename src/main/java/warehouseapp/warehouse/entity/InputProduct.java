package warehouseapp.warehouse.entity;

import lombok.EqualsAndHashCode;
import warehouseapp.warehouse.entity.template.AbsEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
public class InputProduct extends AbsEntity {

    @OneToOne
    private Product product;
    private double amount;
    private double price;
    private Date expireDate;

    @ManyToOne
    private Input input;
}
