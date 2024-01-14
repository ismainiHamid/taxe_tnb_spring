package ma.auth.models.implementations;

import jakarta.persistence.*;
import lombok.*;
import ma.auth.models.GenericModel;

import java.util.List;

@Entity
@Table(name = "roles")
@NoArgsConstructor
@AllArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class Role extends GenericModel {
    @Column(nullable = false, length = 25)
    private String name;

    @ManyToMany
    private List<User> users;
}
