package ma.tnb.respense;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@ToString(callSuper = true)
@Builder(toBuilder = true)
public class Tax {
    private Long id;

    private Double taxRising;

    private Integer year;

    private Long clientId;

    private Long landId;

    private Long categoryId;

    private Rate rate;
}
