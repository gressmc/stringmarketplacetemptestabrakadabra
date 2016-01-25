package grs.epam.data.model;

import java.io.Serializable;

public abstract class AbstractModel<PK extends Serializable> implements Identified<PK> {

    @Override
    public boolean isNew() {
        return getId() == null;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbstractModel)) {
            return false;
        }

        AbstractModel<?> that = (AbstractModel<?>) obj;
        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
