/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultorio;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author emilio
 */
public abstract class Consultorio implements Serializable{
    private static ArrayList<Paciente> pacientes = new ArrayList();
    private static final String archivo = "pacientes.db";
    private static FileInputStream fis = null;
    private static ObjectInputStream ois = null;
    private static FileOutputStream fos = null;
    private static ObjectOutputStream oos = null;
    

    public static String save() {
        String ret = "Carga exitosa";
        boolean flag = true;
        String fileTmp = "tmpFile.db";
        try {
            fos = new FileOutputStream(fileTmp);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(pacientes);
            

        } catch (FileNotFoundException ex) {
            flag = false;
            ret = "No se encuentra el archivo";
            return ret;
        } catch (IOException ex) {
            flag = false;
            ret = "Error al guardar el archivo";
            return ret;
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                    oos = null;
                }
                if (fos != null) {
                    fos.close();
                    fos = null;
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar archivo");
            }
        }
        //Si todo salió bien, se borra el archivo db actual 
        //y lo reemplaza por tmpFile.db
        File fdel = new File(archivo);
        File ftmp = new File(fileTmp);
        if (fdel.exists()) {
            if (fdel.delete()) {
                ftmp.renameTo(new File(archivo));
            }
        } else {
            ftmp.renameTo(new File(archivo));
        }


        return ret;

    }

    public static void load() {
        
        System.out.println("Intentando levantar la lista");
        try {
            fis = new FileInputStream(archivo);
            ois = new ObjectInputStream(fis);

            while (true) {
                pacientes = (ArrayList<Paciente>) ois.readObject();                
            }

        }catch (EOFException e1) {
            //END OF FILE!
            System.out.println("Sale");
        } catch (Exception e2) {
            System.out.println("Error!!!" + e2);
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                    ois = null;
                }
                if (fis != null) {
                    fis.close();
                    fis = null;
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar archivo");
            }
        }
        
    }

    public static ArrayList<Paciente> getPaciente(){
        return pacientes;
    }
    
    public static int addPaciente(Paciente paciente){
        pacientes.add(paciente);
        save();
        load();
        return getPaciente(paciente);
    }
    
    public static Paciente getPaciente(int ordenPaciente){        
        return pacientes.get(ordenPaciente);
    }
    public static void delete(Paciente paciente){
        pacientes.remove(getPaciente(paciente));
        save();
        load();
        
    }
    
    public static int getPaciente(Paciente paciente){
        for (int i=0; i< pacientes.size();i++){
            if (paciente.getDNI() == pacientes.get(i).getDNI()) {
                return i;
            }
        }
        return -1;
        
    }
    
    public static int getCantidadDeAlumnos(){
        return pacientes.size();
    }

   
    
    
}

