/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultorio;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.io.Serializable;

/**
 *
 * @author emilio
 */
public class Paciente implements Serializable{
    public String nombre;
    public int DNI;
    public int edad;
    public String nacimiento;
    public String domicilio;
    public String barrio;
    public String localidad;
    public int telefono;
    public String lugardetrabajo;
    public String jerarquia;
    public String email;

    public Paciente(String nombre, int DNI, int edad, String nacimiento, String domicilio, String barrio, String localidad, int telefono, String lugardetrabajo, String jerarquia, String email) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.edad = edad;
        this.nacimiento = nacimiento;
        this.domicilio = domicilio;
        this.barrio = barrio;
        this.localidad = localidad;
        this.telefono = telefono;
        this.lugardetrabajo = lugardetrabajo;
        this.jerarquia = jerarquia;
        this.email = email;
    }

    public String toString(){
        return "" + this.DNI + "  -  " + this.nombre;
     }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public int getEdad() {
        return edad;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getLugardetrabajo() {
        return lugardetrabajo;
    }

    public void setLugardetrabajo(String lugardetrabajo) {
        this.lugardetrabajo = lugardetrabajo;
    }

    public String getJerarquia() {
        return jerarquia;
    }

    public void setJerarquia(String jerarquia) {
        this.jerarquia = jerarquia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void calcularEdad(String nacimiento){
        Date fechaNac=null;
        try {
        fechaNac = new SimpleDateFormat("dd-MM-yyyy").parse(nacimiento);
        } catch (Exception ex) {
            System.out.println("Error:"+ex);
        }
        Calendar fechaNacimiento = Calendar.getInstance();
      
        Calendar fechaActual = Calendar.getInstance();
      
        fechaNacimiento.setTime(fechaNac);
        
        int año = fechaActual.get(Calendar.YEAR)- fechaNacimiento.get(Calendar.YEAR);
        int mes =fechaActual.get(Calendar.MONTH)- fechaNacimiento.get(Calendar.MONTH);
        int dia = fechaActual.get(Calendar.DATE)- fechaNacimiento.get(Calendar.DATE);
        
        if(mes<0 || (mes==0 && dia<0)){
            año--;
        
        }
        this.edad=año;
        
}

         

}
         
         
    
    
    

