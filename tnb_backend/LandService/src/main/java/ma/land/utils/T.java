package ma.land.utils;

import java.util.Date;

public interface T {
    Long getId();

    void setUpdatedAt(Date updateDate);

    Date getDeletedAt();

    void setDeletedAt(Date deleteDate);
}
