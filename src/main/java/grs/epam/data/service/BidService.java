package grs.epam.data.service;

import grs.epam.data.dao.modelDAO.BidDAO;
import grs.epam.data.dto.BidDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BidService implements GenericService<BidDTO>{

    @Autowired
    private BidDAO bidDAO;

    @Override
    public BidDTO create(BidDTO dto) {
        return null;
    }

    @Override
    public BidDTO update(BidDTO dto) {
        return null;
    }

    @Override
    public BidDTO find(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<BidDTO> findAll() {
        return null;
    }
}
