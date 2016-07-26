/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import java.sql.*;

/**
 *
 * @author emilio
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
 
       
        try {
            String controlador = "org.sqlite.JDBC";
            String cadenaconex = "jdbc:sqlite:test.sqlite";
 
            Class.forName(controlador);
            Connection cn;
            cn = DriverManager.getConnection(cadenaconex);
            Statement st =cn.createStatement();
            String sql1 ="SELECT * FROM Alumno";
            ResultSet rs= st.executeQuery(sql1);
 
            while (rs.next()){
                System.out.print(" nombre: "+rs.getString("nombre"));
                System.out.println(" edad: "+rs.getString("edad"));
            }
 
        } catch (ClassNotFoundException ex) {
            System.out.println("Controlador no válido");
        } catch (SQLException ex) {
             ex.printStackTrace();
        }
 
    }
}

    

    

