package ma.taxe.models.implementations.request;

import lombok.*;
import ma.taxe.models.implementations.Client;
import ma.taxe.models.implementations.Land;

@NoArgsConstructor
@AllArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class Tnb {
    private Client client;
    private Integer year;
    private Land land;
}
