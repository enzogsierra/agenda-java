/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendafx.model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import agendafx.jdbc.Connector;
import agendafx.model.domain.Contacto;
import java.sql.SQLException;

/**
 *
 * @author enzom
 */
public class ContactoRepository implements iCrudRepository
{
    Connection db; // Objeto que se encarga de conectar a la DB
    
    @Override
    public List<?> all()
    {
        List<Contacto> contactos = new ArrayList<>();
        
        try
        {
            db = new Connector().getConnection(); // Conectar a la db
            String query = "SELECT * FROM contactos"; // Consulta SQL
            PreparedStatement st = db.prepareStatement(query); // Preparar consulta en memoria
            ResultSet rs = st.executeQuery(); // Ejecutar la consulta SQl y almacenar los datos en memoria
            
            // Recorrer los datos obtenidos
            while(rs.next()) // Mientras haya resultados
            {
                // En cada iteracion, crear una insancia de un contacto
                // con los valores del resultado (rs) actual 
                // y guardarlo en el array "contactos"
                Contacto contacto = new Contacto
                (
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    null // Por ahora 
                );
                
                contactos.add(contacto); // Añadir contacto al array de contactos
            }
            db.close(); // Cerrar conexión a la db
        }
        catch(SQLException e)
        {
            System.err.println("Error: " + e.getMessage());
        }
        
        return contactos; // Devolver el array de contactos
    }
    
    @Override
    public List<?> findBy(String criterio)
    {
        List<Contacto> contactos = new ArrayList<>(); // Array que almacenará los registros
        
        try
        {
            db = new Connector().getConnection(); // Conectar a la db
            //String query = "SELECT * FROM contactos WHERE nombre LIKE '%" + criterio + "%'";  // Consulta SQL con filtro concatenado (no seguro)
            String query = "SELECT * FROM contactos WHERE nombre LIKE ?"; // Consulta SQL parametrizada (segura)
            PreparedStatement st = db.prepareStatement(query); // Preparar la consulta en memoria
            
            // Preparar los parametros
            criterio = "%" + criterio + "%";
            st.setString(1, criterio);
            
            ResultSet rs = st.executeQuery(); // Ejecutar la consulta SQL y almacenar los datos
            
            while(rs.next()) // Mientras haya resultados en la consulta
            {
                // En cada iteracion, crear una insancia de un contacto
                // con los valores del resultado (rs) actual 
                // y guardarlo en el array "contactos"
                Contacto contacto = new Contacto
                (
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    null // Por ahora 
                );
                
                // Añadir contacto creado al array de contactos
                contactos.add(contacto);
            }
            
            db.close(); // Cerrar la conexión
        }
        catch(SQLException e)
        {
            System.err.println("Error: " + e.getMessage());
        }
        
        return contactos; // Retornar datos
    }
    
    @Override
    public Object findById(int id)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void save(Object object)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void deleteById(int id)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
