package ma.taxe.models.implementations;

import jakarta.persistence.*;
import lombok.*;
import ma.taxe.models.GenericModel;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@Table(name = "tauxs")
@Builder(toBuilder = true)
public class Taux extends GenericModel {
    @Column(nullable = false)
    private Double montant;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Category category;
}
