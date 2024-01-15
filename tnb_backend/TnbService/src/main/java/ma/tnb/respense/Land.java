package ma.tnb.respense;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@ToString(callSuper = true)
public class Land {
    private Long id;

    private String address;

    private Integer surface;

    private Client client;

    private Category category;
}
