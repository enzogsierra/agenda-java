/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendafx.model.repository;

import java.util.List;

/**
 *
 * @author enzom
 */
public interface iCrudRepository 
{
    public List<?> all();
    public List<?> findBy(String criterio);
    public Object findById(int id);
    
    public void save(Object object);
    public void deleteById(int id);
}
