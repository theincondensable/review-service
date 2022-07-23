package io.incondensable.review.data.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "manager")
public class ManagerEntity {

    @Id
    @GeneratedValue
    private long id;

    @JoinColumn()
    @OneToMany
    private List<ProductEntity> controlledProducts;

}
