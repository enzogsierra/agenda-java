package agendafx.model.repository;

import java.util.List;

/**
 *
 * author alexander baikalov
 */

public interface iCrudRepository 
{
    List<?> all();
    List<?> findBy(String criterio);
    Object findById(int id);
    
    void save(Object object);
    void deleteById(int id);
}
