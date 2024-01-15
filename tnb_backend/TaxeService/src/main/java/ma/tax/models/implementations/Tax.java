package ma.tax.models.implementations;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.ws.rs.client.Client;
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
    private Boolean pay = false;

    @Column(nullable = false)
    private Long clientId;

    @Column(nullable = false)
    private Long landId;

    @Column(nullable = false)
    private Long categoryId;

    @ManyToOne
    private Rate rate;
}
