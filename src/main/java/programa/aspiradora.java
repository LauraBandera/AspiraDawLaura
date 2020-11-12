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
    static String uPredeterminado = "usuario", cPredeterminada = "usuario";
    static double dependencias[];

    public static void main(String[] args) {

        inicioSesion();
        menu();

        //PUNTO 7
        //Salir
    }

    //Metedo para iniciar sesion en sistema
    public static void inicioSesion() {

        String usuario, contrasenia;
        do {
            usuario = JOptionPane.showInputDialog(null, "Introduzca el "
                    + "usuario");
            contrasenia = JOptionPane.showInputDialog(null, "Introduzca "
                    + "la contraseña");
        } while (!usuario.equals(uPredeterminado)
                || !contrasenia.equals(cPredeterminada));
    }
    
    //Metodo que meuestra el menú con las diferenctes opciones
    public static void menu() {
        int seleccion;
        do {
            teclado = JOptionPane.showInputDialog(null, "Introduzca la opción "
                    + "deseada:\n"
                    + "1 - Configurar sistema\n"
                    + "2 - Establecer Carga\n"
                    + "3 - Selección de Modo (Aspiración o Aspiración y Fregado\n"
                    + "4 - Estado general\n"
                    + "5 - Llevar a base de Carga\n"
                    + "6 - Salir");
            seleccion = Integer.parseInt(teclado);
        } while (seleccion < 1 || seleccion > 6);
        seleccionMenu(seleccion);
    }

    //Metodo que activas la seleccion del menú
    public static void seleccionMenu(int seleccion) {
        switch (seleccion) {
            case 1:
                configuracionSistema();
                break;
            case 2:
                inicializacionBateria();
                break;
            case 3:
                seleccionModo();
                break;
            case 4:
                estadoGeneral();
                break;
            case 5:
                cargaBateria();
                break;
            default:
                break;
        }
        if(seleccion != 6){
            menu();
        }
    }

    //Metodo que configura el sistema (dependencias y metros^2 de cada una)
    public static void configuracionSistema() {
        //Declaración de array para dependencias.
        teclado = JOptionPane.showInputDialog(null, "Introduzca la cantidad "
                + "de dependencias");
        dependencias = new double[Integer.parseInt(teclado)];

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

    //Metodo para introducir la Batería actual
    public static void inicializacionBateria() {
        //PUNTO 2
        teclado = JOptionPane.showInputDialog(null, "Introduzca la bateria:");
        bateria = Double.parseDouble(teclado);
    }

    //Metodo para selección del modo de limpieza (incluye aspiración solo
    //y asparación junto con fregado
    public static void seleccionModo() {
        int modo;
        teclado = JOptionPane.showInputDialog(null, "¿Ha realizado con "
                + "anterioridad la configuración del sistema y"
                + " ha establecido la carga?");
        if(teclado.equals("Si")){
            do {
                teclado = JOptionPane.showInputDialog(null, "Introduzca el modo"
                    + " que desee\n1 - Aspiración en Modo Completo"
                    + "\n2 - Aspiración en Modo Dependencias"
                    + "\n3 - Aspiración y Fregado en Modo Completo"
                    + "\n4 - Aspiración y Fregado en Modo Dependencias");
                modo = Integer.parseInt(teclado);
            } while (modo < 1 || modo > 4);
            //Array que usaremos para los los siguientes metodos
            boolean limpias[] = new boolean[dependencias.length];
            double bateriaDependencia[] = new double[dependencias.length];
            //Variables a usar
            final double BATERIA;
            
            //Estructura que se encarga de inicializar la constante bateria
            //según si es modo aspiración o aspiració y fregado
            if (modo == 1 || modo == 2) {
                BATERIA = 1.5;
            } else {
                BATERIA = 2.25;
            }
            switch (modo) {
                //PUNTO 3
                case 1:
                    modoCompleto(bateriaDependencia, limpias, BATERIA);
                    break;
                case 2:
                    modoDependencias(bateriaDependencia, limpias, BATERIA);
                    break;
                //PUNTO 4    
                case 3:
                    modoCompleto(bateriaDependencia, limpias, BATERIA);
                    break;
                case 4:
                    modoDependencias(bateriaDependencia, limpias, BATERIA);
                    break;
            }
        }else{
            JOptionPane.showMessageDialog(null, "Vaya primero a 'configuración "
                    + "sistema' y posteriormente a 'Establecer carga'");
        }
    }

    //Metodo que se encarga del Modo Completo
    public static void modoCompleto( double bateriaDependencia[],
            boolean limpias[], double BATERIA) {
        
        for (int i = 0; i < bateriaDependencia.length; i++) {
            bateriaDependencia[i] = dependencias[i] * BATERIA;
            descargarBateria(i, bateriaDependencia, limpias);
        }
        String limpio = "";
        String noLimpio = "";
        for (int i = 0; i < limpias.length; i++) {
            if (limpias[i]) {
                limpio += "dependecia " + i + " ";
            } else {
                noLimpio += "dependecia " + i + " ";
            }
        }
        JOptionPane.showMessageDialog(null, "Las dependencias limpiadas son: " + limpio);
        JOptionPane.showMessageDialog(null, "Las dependencias NO limpiadas son: " + noLimpio);
    }

    //Metodo que se encarga del Modo Dependencias
    public static void modoDependencias(double bateriaDependencia[],
            boolean limpias[], double BATERIA) {
        //Variables a usar
        int pendienteLimpiar;
        for (int i = 0; i < bateriaDependencia.length; i++) {
            bateriaDependencia[i] = dependencias[i] * BATERIA;
        }
        do {
            do {
                teclado = JOptionPane.showInputDialog(null, "¿Desea limpiar alguna "
                        + "habitación? \nIntroduzca:\n1 - Sí\n2 - No");
                pendienteLimpiar = Integer.parseInt(teclado);
            } while (pendienteLimpiar != 1 && pendienteLimpiar != 2);

            if (pendienteLimpiar == 1) {
                do {
                    teclado = JOptionPane.showInputDialog(null, "Introduzca el número "
                            + "de habitación a limpiar");
                    pendienteLimpiar = Integer.parseInt(teclado);
                } while (pendienteLimpiar > dependencias.length || pendienteLimpiar < 0);
                descargarBateria(pendienteLimpiar, bateriaDependencia, limpias);
            }
        } while (pendienteLimpiar != 2);
    }

    //Metodo que se encarga de descargar la bateria tanto en modo completo como
    //en modo dependencia
    public static void descargarBateria(int hab, double bateriaDependencia[],
            boolean limpias[]){
        
        if (bateria > bateriaDependencia[hab] && bateria > 3) {
                bateria -= bateriaDependencia[hab];
                limpias[hab] = true;
                System.out.println("Se ha limpiado la habitación: " + hab);
        } else {
                limpias[hab] = false;
                System.out.println("No tiene suficiente"
                            + "bateria para limpiar la habitacioón " + hab);
        }
    }
    
    //Método que muestra el estado general de las aspiradora
    public static void estadoGeneral() {
        //PUNTO 5
        LocalDateTime localDateTime = LocalDateTime.now();
        double metros = 0;

        for (int i = 0; i < dependencias.length; i++) {
            metros += dependencias[i];
        }

        String estadoGeneral = "La hora y fecha de hoy es: " + localDateTime
                + "\nEl nivel de batería es: " + bateria + "\nEl lugar donde se "
                + "encuentra es la habitacion " + posicion
                + "\nEl número de dependencias es: "+ dependencias.length 
                + "\nLos metros cuadrados de la casa son: " + metros;
        JOptionPane.showMessageDialog(null, estadoGeneral);
    }

    //Metodo que se encarga de llevar la aspiradora a la base de carga
    public static void cargaBateria() {
        //PUNTO 6
        bateria = 100;
        JOptionPane.showMessageDialog(null, "Cargando... Batería cargada.");
    }
}
