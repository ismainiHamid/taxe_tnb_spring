package ma.taxe.models.implementations;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import ma.taxe.models.GenericModel;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@Table(name = "categories")
public class Category extends GenericModel {
    @Column(nullable = false, length = 50)
    private String label;

    @Column(nullable = true)
    private String description;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Terrain> terrains;
}
