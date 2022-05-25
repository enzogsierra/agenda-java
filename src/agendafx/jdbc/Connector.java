package agendafx.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * author alexander baikalov
 */
public class Connector 
{
    public Connection getConnection()
    {
        try 
        {
            return DriverManager.getConnection("jdbc:mysql://localhost/agendajfx", "root", "");
        } 
        catch (SQLException e) 
        {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
}
