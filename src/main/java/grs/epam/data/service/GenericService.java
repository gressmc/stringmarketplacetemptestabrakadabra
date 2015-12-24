package grs.epam.data.service;

import java.util.List;

public interface GenericService <DTOBJECT> {
    DTOBJECT create(DTOBJECT dto);
    DTOBJECT update(DTOBJECT dto);
    DTOBJECT find(Integer id);
    void delete(Integer id);
    List<DTOBJECT> findAll();
}
