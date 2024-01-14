package ma.land.models.implementations;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import ma.land.models.GenericModel;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@Table(name = "lands")
public class Land extends GenericModel {
    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Integer surface;

    @ManyToOne
    private  Client client;

    @ManyToOne
    private Category category;

}
