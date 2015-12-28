package grs.epam.data.service;


import grs.epam.data.dao.modelDAO.ItemDAO;
import grs.epam.data.dto.ItemDTO;
import grs.epam.data.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service("itemService")
public class ItemService implements GenericService<ItemDTO> {

    @Autowired
    private ItemDAO itemDAO;

    private List<Item> getAllItems() {
        return null;
    }

    private List<Item> getItemsByOwn(String own) {
        return null;
    }

    public String getItems() {
        return "";
    }

    public void newItem() {
    }

    public void deleteItem() {
    }


    @Override
    public ItemDTO create(ItemDTO dto) {
        return null;
    }

    @Override
    public ItemDTO update(ItemDTO dto) {
        return null;
    }

    @Override
    public ItemDTO find(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<ItemDTO> findAll() {
        return null;
    }
}
