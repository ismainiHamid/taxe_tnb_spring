package ma.auth.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import ma.auth.utils.T;

import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class GenericModel implements Serializable, T {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date createdAt = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date updatedAt = null;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date deletedAt = null;
}
