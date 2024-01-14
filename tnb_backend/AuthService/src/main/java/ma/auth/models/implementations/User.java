package ma.auth.models.implementations;

import jakarta.persistence.*;
import lombok.*;
import ma.auth.models.GenericModel;

import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class User extends GenericModel {
    @Column(nullable = false, length = 50)
    private String fullName;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private List<Role> roles;
}
