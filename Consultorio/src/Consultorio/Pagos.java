/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultorio;

/**
 *
 * @author emilio
 */
public class Pagos {
    public String obrasocial;
    public int carnetobrasocial;
    public float cuenta;
    public String titularos;

    public String getObrasocial() {
        return obrasocial;
    }

    public void setObrasocial(String obrasocial) {
        this.obrasocial = obrasocial;
    }

    public int getCarnetobrasocial() {
        return carnetobrasocial;
    }

    public void setCarnetobrasocial(int carnetobrasocial) {
        this.carnetobrasocial = carnetobrasocial;
    }

    public float getCuenta() {
        return cuenta;
    }

    public void setCuenta(float cuenta) {
        this.cuenta = cuenta;
    }

    public String getTitularos() {
        return titularos;
    }

    public void setTitularos(String titularos) {
        this.titularos = titularos;
    }
    
    public void setDescuentos(String obrasocial){
    /*Dependiendo las obras sociales con las que trabaje el cliente aqui se encontraran los descuentos 
      a realizarse por cada obra social que atienda el consultorio*/
    }
    
}
