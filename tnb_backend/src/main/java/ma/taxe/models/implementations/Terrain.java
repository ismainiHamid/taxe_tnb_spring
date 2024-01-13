package ma.taxe.models.implementations;

import jakarta.persistence.*;
import lombok.*;
import ma.taxe.models.GenericModel;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@Table(name = "terrains")
public class Terrain extends GenericModel {
    @Column(nullable = false, length = 200)
    private String nom;

    @Column(nullable = false)
    private Integer surface;

    @ManyToOne
    private  Client client;

    @ManyToOne
    private Category category;

}
