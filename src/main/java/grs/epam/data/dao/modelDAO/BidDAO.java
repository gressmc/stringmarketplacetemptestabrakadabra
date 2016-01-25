package grs.epam.data.dao.modelDAO;

import grs.epam.data.dao.Base.GenericDAO;
import grs.epam.data.model.Bid;

public interface BidDAO extends GenericDAO<Bid, Integer> {

    @Override
    default Class<Bid> getEntityClass() {
        return Bid.class;
    }

}
