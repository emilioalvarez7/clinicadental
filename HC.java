/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultorio;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
        
/**
 *
 * @author tincho
 */
public class HC {
    private static String db = "Paciente";
    private static String user = "root";
    private static String pass = "Lescano2015";
    private static String url = "jdbc:mysql://localhost/" + db;
    private static Connection Conn;
    
    public static Connection getConecction(){
        try{
           Class.forName("com.mysql.jdbc.Driver");
           Conn=DriverManager.getConnection(url, user, pass);
           
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Database error  " + e.getMessage());
                }
        return Conn;
    }
}
