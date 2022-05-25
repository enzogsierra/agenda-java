package agendafx.model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import agendafx.jdbc.Connector;
import agendafx.model.dto.ContactoDTO;
import java.sql.SQLException;

/**
 *
 * author alexander baikalov
 */
public class ContactoRepository implements iCrudRepository
{
    @Override
    public List<?> all()
    {
        List<ContactoDTO> contactos = new ArrayList<>();
        
        try
        {
            Connection db = new Connector().getConnection(); // Conectar a la db
            String query = "SELECT * FROM contactos"; // Consulta SQL
            PreparedStatement st = db.prepareStatement(query); // Preparar consulta en memoria
            ResultSet rs = st.executeQuery(); // Ejecutar la consulta SQl y almacenar los datos en memoria
            
            // Recorrer los datos obtenidos
            while(rs.next()) // Mientras haya resultados
            {
                //

                // En cada iteracion, crear una insancia de un contacto
                // con los valores del resultado (rs) actual 
                // y guardarlo en el array "contactos"
                ContactoDTO contacto = new ContactoDTO
                (
                    rs.getInt(1), // id
                    rs.getString(2) + " " + rs.getString(3), // contacto
                    rs.getString(4), // telefono
                    rs.getString(5), // email
                    rs.getString(6) // notas
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
        List<ContactoDTO> contactos = new ArrayList<>(); // Array que almacenará los registros
        
        try
        {
            Connection db = new Connector().getConnection(); // Conectar a la db
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
                ContactoDTO contacto = new ContactoDTO
                (
                    rs.getInt(1), // id
                    rs.getString(2) + " " + rs.getString(3), // contacto
                    rs.getString(4), // telefono
                    rs.getString(5), // email
                    rs.getString(6) // notas
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

    public void delete(ContactoDTO contacto) {
        Connection db = new Connector().getConnection();
        String query = "DELETE FROM contactos WHERE id = ?";
        try {
            PreparedStatement st = db.prepareStatement(query);
            st.setInt(1, contacto.getId());
            st.executeUpdate();
            db.close();
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
