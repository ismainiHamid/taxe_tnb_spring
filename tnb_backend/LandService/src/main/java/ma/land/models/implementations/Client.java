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
@Table(name = "clients")
public class Client extends GenericModel {
    @Column(nullable = false, length = 50)
    private String fullName;

    @Column(nullable = false, length = 10)
    private String cardNumber;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Land> lands;
}
