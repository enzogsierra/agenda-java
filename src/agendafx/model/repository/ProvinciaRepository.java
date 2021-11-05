/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendafx.model.repository;

import agendafx.jdbc.Connector;
import agendafx.model.domain.Provincia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author enzom
 */
public class ProvinciaRepository implements iCrudRepository
{
    @Override
    public List<?> all() 
    {
        List<Provincia> provincias = new ArrayList<>();
        
        try
        {
            Connection db = new Connector().getConnection();
            
            //
            String query = "SELECT * FROM provincias";
            PreparedStatement ps = db.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                Provincia provincia = new Provincia();
                provincia.setId(rs.getInt("id"));
                provincia.setNombre(rs.getString("nombre"));
                
                provincias.add(provincia);
            }
        }
        catch(SQLException e)
        {
            System.err.println("Error: " + e.getMessage());
        }
        return provincias;
    }

    @Override
    public List<?> findBy(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object findById(int id)
    {
        Provincia provincia = new Provincia();
        
        try
        {
            Connection db = new Connector().getConnection();
            
            //
            String query = "SELECT * FROM provincias WHERE id = ? LIMIT 1";
            PreparedStatement ps = db.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                provincia.setId(rs.getInt("id"));
                provincia.setNombre(rs.getString("nombre"));
            }
        }
        catch(SQLException e)
        {
            System.err.println("Error: " + e.getMessage());
        }
        return provincia;
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
