package ma.taxe.models.implementations;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import ma.taxe.models.GenericModel;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@Table(name = "taxeTnbs")
public class TaxeTnb extends GenericModel {
    @Column(nullable = false)
    private String label;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer tnbYear;

    @Column(nullable = false)
    private Double montantYear;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonIgnore
    private Land land;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonIgnore
    private Category category;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonIgnore
    private Taux taux;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonIgnore
    private Client client;
}
