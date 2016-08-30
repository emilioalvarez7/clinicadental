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
public class ObraSocial {
    public String obrasocial;
    public int carnetobrasocial;
    public float cuenta;
    public String titular;

    public ObraSocial(String obrasocial, int carnetobrasocial, float cuenta, String titular) {
        this.obrasocial = obrasocial;
        this.carnetobrasocial = carnetobrasocial;
        this.cuenta = cuenta;
        this.titular = titular;
        
    }

    public String toString(){
        return "" + this.cuenta + "  -  " + this.obrasocial;
     }
    
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

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titularos) {
        this.titular = titularos;
    }
    
    public void setDescuentos(String obrasocial){
    /*Dependiendo las obras sociales con las que trabaje el cliente aqui se encontraran los descuentos 
      a realizarse por cada obra social que atienda el consultorio*/
    }

    

    
}
