package ma.tax.models.implementations;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import ma.tax.models.GenericModel;

@Entity
@Table(name = "rates")
@NoArgsConstructor
@AllArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class Rate extends GenericModel {
    @Column(nullable = false)
    private Integer ratePercent;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false)
    private Long categoryId;
}
