/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultorio;
import java.sql.*;
import gui.inicio;
/**
 *
 * @author emilio
 */
public class Main {

    
    public static void main(String[] args){
 
   
         
        Paciente a = new Paciente();
        a.setNacimiento("08-05-2000");
        a.calcularEdad(a.nacimiento);
        System.out.println("edad" + a.edad);
                
}
    
    }


    

    

