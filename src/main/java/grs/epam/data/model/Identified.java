package grs.epam.data.model;

import java.io.Serializable;

public interface Identified<PK extends Serializable> {
    PK getId();
    boolean isNew();
}
