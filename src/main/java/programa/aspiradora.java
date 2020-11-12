/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

/**
 *
 * @author laura
 */

import javax.swing.JOptionPane;

public class aspiradora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Declaramos las variables que vayamos a usar
        double mSalon, mCocina, mBanio, mDormitorio1, mDormitorio2, bateria;
        String teclado;
        
        //PUNTO 1
        //Incializamos las variables relativas a las dependencias
        do{
            teclado = JOptionPane.showInputDialog(null, "Introduzca los metros"
                    + " cuadrados que tiene el Salón.");
            mSalon = Double.parseDouble(teclado);
        }while(mSalon < 1 || mSalon > 100);
        
        do{
            teclado = JOptionPane.showInputDialog(null, "Introduzca los metros"
                    + " cuadrados que tiene la Cocina.");
            mCocina = Double.parseDouble(teclado);
        }while(mCocina < 1 || mCocina > 100);
        
        do{
            teclado = JOptionPane.showInputDialog(null, "Introduzca los metros"
                    + " cuadrados que tiene el Baño.");
            mBanio = Double.parseDouble(teclado);
        }while(mBanio < 1 || mBanio > 100);
        
        do{
            teclado = JOptionPane.showInputDialog(null, "Introduzca los metros"
                    + " cuadrados que tiene el Dormitorio1.");
            mDormitorio1 = Double.parseDouble(teclado);
        }while(mDormitorio1 < 1 || mDormitorio1 > 100);
        
        do{
            teclado = JOptionPane.showInputDialog(null, "Introduzca los metros"
                    + " cuadrados que tiene el Dormitorio2.");
            mDormitorio2 = Double.parseDouble(teclado);
        }while(mDormitorio2 < 1 || mDormitorio2 > 100);
        
        //PUNTO 2
        teclado = JOptionPane.showInputDialog(null, "Introduzca la bateria:");
        bateria = Double.parseDouble(teclado);
        
        //PUNTO 3
        
        //Usar booleanos para las dependencias limpiadas
        //En base de carga solo poner 100%
    }
    
}
