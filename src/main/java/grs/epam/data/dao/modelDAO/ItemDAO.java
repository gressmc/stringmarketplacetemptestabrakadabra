package grs.epam.data.dao.modelDAO;

import grs.epam.data.dao.Base.GenericDAO;
import grs.epam.data.model.Item;

public interface ItemDAO extends GenericDAO<Item, Integer> {

    @Override
    default Class<Item> getEntityClass() {
        return Item.class;
    }
}
