package grs.epam.data.service;


import grs.epam.data.dto.ItemDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("itemService")
public class ItemService implements GenericService<ItemDTO>{

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
