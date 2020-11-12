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
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

public class aspiradora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //Declaramos las variables que vayamos a usar
        double bateria;
        String teclado;

        //Declaración de array para dependencias.
        teclado = JOptionPane.showInputDialog(null, "Introduzca la cantidad "
                + "de dependencias");
        double dependencias[] = new double[Integer.parseInt(teclado)];

        //PUNTO 1
        //Incializamos las variables relativas a las dependencias
        for (int i = 0; i < dependencias.length; i++) {
            do {
                teclado = JOptionPane.showInputDialog(null, "Introduzca los "
                        + "metros cuadrados que tiene la dependencia " + i);
                dependencias[i] = Integer.parseInt(teclado);
            } while (dependencias[i] < 1 || dependencias[i] > 100);
        }

        //PUNTO 2
        teclado = JOptionPane.showInputDialog(null, "Introduzca la bateria:");
        bateria = Double.parseDouble(teclado);

        //PUNTO 3
        //Modo completo
        //Variables a usar
        final double BATERIA = 1.5;
        boolean limpias[] = new boolean[dependencias.length];
        double bateriaDependencia[] = new double[dependencias.length];
        for (int i = 0; i < bateriaDependencia.length; i++) {
            bateriaDependencia[i] = dependencias[i] * BATERIA;
            if (bateria > bateriaDependencia[i] && bateria > 3) {
                bateria -= bateriaDependencia[i];
                limpias[i] = true;
                System.out.println("Se ha limpiado la habitación: " + i);
            } else {
                limpias[i] = false;
                System.out.println("NO se ha limpiado la habitación: " + i);
            }
        }
        String limpio = "";
        String noLimpio = "";
        for (int i = 0; i < limpias.length; i++) {
            if (limpias[i]) {
                limpio += i + " ";
            } else {
                noLimpio += i + " ";
            }
        }
        JOptionPane.showMessageDialog(null, "Las dependencias limpiadas son: " + limpio);
        JOptionPane.showMessageDialog(null, "Las dependencias NO limpiadas son: " + noLimpio);

        //Modo dependencias
        //Variables a usar
        int limpiar, posicion = 0;
        do {
            do {
                teclado = JOptionPane.showInputDialog(null, "¿Desea limpiar alguna "
                        + "habitación? \nIntroduzca:\n1 - Sí\n2 - No");
                limpiar = Integer.parseInt(teclado);
            } while (limpiar != 1 && limpiar != 2);

            if (limpiar == 1) {
                teclado = JOptionPane.showInputDialog(null, "Introduzca el número "
                        + "de habitación a limpiar");
                limpiar = Integer.parseInt(teclado);
                //Código repetido meter en un método (línea 52)
                if (bateria > bateriaDependencia[limpiar] && bateria > 3) {
                    bateria -= bateriaDependencia[limpiar];
                    limpias[limpiar] = true;
                    posicion = limpiar;
                    System.out.println("Se ha limpiado la habitación: " + limpiar);
                } else {
                    limpias[limpiar] = false;
                    System.out.println("NO se ha limpiado la habitación: " + limpiar);
                }
            }
        } while (limpiar != 2);

        //PUNTO 4
        final double BATERIA_AYF = 2.25;
        //añadir método para hacer lo mismo qe anteriormente

        //PUNTO 5
        LocalDateTime localDateTime = LocalDateTime.now();
        double metros = 0;
        
        for (int i = 0; i < dependencias.length; i++) {
            metros += dependencias[i];
        }
        
        String estadoGeneral = "La hora y fecha de hoy es: " + localDateTime
                + "\nEl nivel de batería es: " + bateria + "\nEl lugar donde se "
                + "encuentra " + posicion + " el número de dependencias es: " 
                + dependencias.length + " los metros cuadrados de la casa son: " 
                + metros;
        JOptionPane.showMessageDialog(null, estadoGeneral);

        //Usar booleanos para las dependencias limpiadas
        //En base de carga solo poner 100%
        /*
        Saber fecha y hora con LocalDate y LocalTime
        api java time (8)
        LocalDateTime
         */
    }

}
