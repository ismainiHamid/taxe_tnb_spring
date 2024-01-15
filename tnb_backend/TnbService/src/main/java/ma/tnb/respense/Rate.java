package ma.tnb.respense;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@ToString(callSuper = true)
public class Rate {
    private Long id;

    private Integer ratePercent;

    private Integer year;

    private Long categoryId;
}
