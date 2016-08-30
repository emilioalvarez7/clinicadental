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


public abstract class PDP implements Serializable{
    private static ArrayList<ObraSocial> pagos = new ArrayList();
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
            oos.writeObject(pagos);
            

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
                pagos = (ArrayList<ObraSocial>) ois.readObject();                
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

    public static ArrayList<ObraSocial> getPagos(){
        return pagos;
    }
    
    public static int addPagos(ObraSocial pagos){
        PDP.pagos.add(pagos);
        save();
        load();
        return getPagos(pagos);
    }
    
    public static ObraSocial getPagos(int ordenPagos){        
        return pagos.get(ordenPagos);
    }
    public static void delete(ObraSocial pagos){
        PDP.pagos.remove(getPagos(pagos));
        save();
        load();
        
    }
    
    public static int getPagos(ObraSocial pagos){
        for (int i=0; i< PDP.pagos.size();i++){
            if (pagos.getCuenta() == PDP.pagos.get(i).getCuenta()) {
                return i;
            }
        }
        return -1;
        
    }
    
    public static int getCantidadDePagos(){
        return pagos.size();
    }

   
    
    
}