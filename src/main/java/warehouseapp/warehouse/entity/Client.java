package warehouseapp.warehouse.entity;

import lombok.EqualsAndHashCode;
import warehouseapp.warehouse.entity.template.AbsEntity;
import warehouseapp.warehouse.entity.template.AbsNameEntity;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
public class Client extends AbsNameEntity {
    private String phoneNumber;
}
