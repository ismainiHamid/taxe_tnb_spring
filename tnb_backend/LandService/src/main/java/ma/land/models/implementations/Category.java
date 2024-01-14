package ma.land.models.implementations;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import ma.land.models.GenericModel;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@Table(name = "categories")
public class Category extends GenericModel {
    @Column(nullable = false, length = 50, unique = true)
    private String label;

    @Column(nullable = false)
    private Double rising;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Land> lands;
}
