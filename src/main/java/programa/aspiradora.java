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

    //Declaramos las variables que vayamos a usar
    static double bateria;
    static String teclado;
    static int posicion;

    public static void main(String[] args) {
        //PUNTO 7
        //Salir
    }

    public void inicializacionDependencias() {
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
    }

    public void inicializacionBateria() {
        //PUNTO 2
        teclado = JOptionPane.showInputDialog(null, "Introduzca la bateria:");
        bateria = Double.parseDouble(teclado);
    }

    public void seleccionModo(double dependencias[]) {
        int modo;
        do {
            teclado = JOptionPane.showInputDialog(null, "Introduzca el modo"
                    + " que desee\n1 - Aspiración en Modo Completo"
                    + "\n2 - Aspiración en Modo Dependencias"
                    + "\n3 - Aspiración y Fregado en Modo Completo"
                    + "\n4 - Aspiración y Fregado en Modo Dependencias");
            modo = Integer.parseInt(teclado);
        }while(modo < 1 || modo > 4); 
        //Array que usaremos para los los siguientes metodos
        boolean limpias[] = new boolean[dependencias.length];
        double bateriaDependencia[] = new double[dependencias.length];
        //Variables a usar
        final double BATERIA;
        if(modo == 1 || modo == 2){
            BATERIA = 1.5;
        }else{
            BATERIA = 2.25;
        }
        switch(modo){
                //PUNTO 3
                case 1:
                    modoCompleto(dependencias, bateriaDependencia, limpias,
                            BATERIA);
                case 2:
                    modoDependencias(dependencias, bateriaDependencia, limpias,
                            BATERIA);
                //PUNTO 4    
                case 3:
                    modoCompleto(dependencias, bateriaDependencia, limpias,
                            BATERIA);
                case 4:
                    modoDependencias(dependencias, bateriaDependencia, limpias,
                            BATERIA);
        }
    }

    public void modoCompleto(double dependencias[],double bateriaDependencia[],
            boolean limpias[], double BATERIA) {
        //Modo completo
        
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
    }

    public void modoDependencias(double dependencias[], double bateriaDependencia[],
            boolean limpias[], double BATERIA) {
        //Modo dependencias
        //Variables a usar
        int limpiar;
        do {
            do {
                teclado = JOptionPane.showInputDialog(null, "¿Desea limpiar alguna "
                        + "habitación? \nIntroduzca:\n1 - Sí\n2 - No");
                limpiar = Integer.parseInt(teclado);
            } while (limpiar != 1 && limpiar != 2);

            if (limpiar == 1) {
                do {
                    teclado = JOptionPane.showInputDialog(null, "Introduzca el número "
                            + "de habitación a limpiar");
                    limpiar = Integer.parseInt(teclado);
                } while (limpiar > dependencias.length || limpiar < 0);
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
    }
    
    void estadoGenera(double dependencias[]){
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
    }
    
    void cargaBateria(){
        //PUNTO 6
        bateria = 100;
        JOptionPane.showMessageDialog(null, "Cargando... Batería cargada.");

    }
}
