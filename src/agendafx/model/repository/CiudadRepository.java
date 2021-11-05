/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendafx.model.repository;

import agendafx.jdbc.Connector;
import agendafx.model.domain.Ciudad;
import agendafx.model.domain.Provincia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author enzom
 */
public class CiudadRepository implements iCrudRepository
{
    ProvinciaRepository provinciaRepo = new ProvinciaRepository();
    
    @Override
    public List<?> all() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<?> findBy(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object findById(int id) 
    {
        Ciudad ciudad = new Ciudad();
        
        try
        {
            Connection db = new Connector().getConnection();
            
            //
            String query = "SELECT * FROM ciudades WHERE id = ?";
            PreparedStatement ps = db.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                Provincia provincia; 
                provincia = (Provincia)provinciaRepo.findById(rs.getInt("provinciaId"));
                
                ciudad.setId(rs.getInt("id"));
                ciudad.setNombre(rs.getString("nombre"));
                ciudad.setCpa(rs.getString("cpa"));
                ciudad.setProvincia(provincia);
            }
        }
        catch(SQLException e)
        {
            System.err.println("Error: " + e.getMessage());
        }
        return ciudad;
    }

    @Override
    public void save(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
