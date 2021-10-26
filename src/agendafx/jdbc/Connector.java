/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendafx.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author enzom
 */
public class Connector 
{
    public Connection getConnection()
    {
        try 
        {
            return DriverManager.getConnection("jdbc:mysql://localhost/agendajfx", "root", "root");
        } 
        catch (SQLException e) 
        {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
}
