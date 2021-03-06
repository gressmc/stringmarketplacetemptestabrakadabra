package grs.epam.data.dao.modelDAO.Impl;

import grs.epam.data.dao.Base.AbstractDAO;
import grs.epam.data.dao.modelDAO.BidDAO;
import grs.epam.data.model.Bid;
import org.springframework.stereotype.Repository;

@Repository("bidDAO")
public class BidDAOImpl extends AbstractDAO<Bid, Integer> implements BidDAO {

    @Override
    public String getAllQuery() {
        return "Bid.getAll";
    }

}
