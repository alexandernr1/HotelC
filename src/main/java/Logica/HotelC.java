

package Logica;


import Presentacion.Juselogin;


public class HotelC {

    public static void main(String[] args) {
        Juselogin prin = new Juselogin();
    prin.setVisible(true);
        Cconexion objetoConexion = new Cconexion();
        objetoConexion.establecerConexion();
        
       
    }
    
}
