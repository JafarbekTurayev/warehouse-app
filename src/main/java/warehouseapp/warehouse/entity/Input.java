package warehouseapp.warehouse.entity;

import lombok.EqualsAndHashCode;
import warehouseapp.warehouse.entity.template.AbsEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@EqualsAndHashCode(callSuper = true)
public class Input extends AbsEntity {

    private Date date;

    @ManyToOne
    private Warehouse warehouse;

    @ManyToOne
    private Supplier supplier;

    @ManyToOne
    private Currency currency;

    private String factureNumber;
    private String code;

}
