package grs.epam.data.dao.modelDAO.Impl;

import grs.epam.data.dao.Base.AbstractDAO;
import grs.epam.data.dao.modelDAO.ItemDAO;
import grs.epam.data.model.Item;

public class ItemDAOImpl extends AbstractDAO<Item, Integer> implements ItemDAO {

    @Override
    public String getAllQuery() {
        return "Item.getAll";
    }

}
