package ma.tax.models.implementations;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import ma.tax.models.GenericModel;

@Entity
@Table(name = "taxes")
@NoArgsConstructor
@AllArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class Tax extends GenericModel {
    @Column(nullable = false)
    private Double taxRising;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false)
    private Long clientId;
}
