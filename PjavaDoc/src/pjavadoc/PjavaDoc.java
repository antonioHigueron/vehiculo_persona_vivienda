/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pjavadoc;

import java.util.Scanner;

/**
 * Programa de registro de información estructurado en torno a tres alternativas
 * según que los datos a registrar correspondan a un vehículo, a una persona o a
 * una vivienda.
 *
 * @author Piedad
 */
public class PjavaDoc {

    /**
     * Variables de clase: opcionCorrecta: variable de tipo boolean que se
     * utiliza en el main más en el método validaOpcion para confirmar que el
     * usuario introduce un valor válido para la variable opcion
     */
    
    public static String textoError = "La opción introducida no es válida. Por favor, "
                + "introduzca una opción válida";
    public static boolean opcionCorrecta = false;
    public static boolean matCorrecta = false;
    public static boolean tipoVCorrecto = false;

    public static Scanner entrada = new Scanner(System.in);
    public static String option;
    public static int reinicio;
    public static String opciones[] = {"VIVIENDA", "VEHICULO", "PERSONA"};
    public static String tipoVeh[] = {"turismo", "todoterreno", "sub", "comercial", "motocicleta", "ciclomotor", "agrícola", "camión", "autobús"};

    public static void main(String[] args) {
        // TODO code application logic here

        /**
         * VARIABLES entrada: instancia de la clase Scanner para entrada de
         * datos option: variable de tipo String que almacena las entradas por
         * teclado opciones: array de tipo String que contiene los valores de
         * entrada aceptados por el programa
         */
        System.out.println("***********************************");
        System.out.println("Programa de registro de información");
        System.out.println("***********************************");
        System.out.println("");

        do {

            System.out.println("¿Qué información quiere registrar?");
            System.out.printf("Las opciones disponibles son: \n");
            bucleOpciones(opciones);
            System.out.println("");
            option = entrada.next();
            validaOpcion(opciones, option);
            
            
            
            
            
            
            
            
            
        
        /**
         * Switch case para ejecutar las acciones que correspondan según el tipo
         * de información a registrar
         */
        String opcionIntroducida = option.toUpperCase();
        
        switch (opcionIntroducida) {
            case "VEHICULO":

                Vehiculo unVehVacio = new Vehiculo();
                String marca,
                 modelo,
                 matricula,
                 tipo,
                 color;
                int anyos;

                System.out.println("Introduzca marca del vehículo:");
                marca = entrada.next();
                System.out.println("Introduzca modelo del vehículo:");
                modelo = entrada.next();

                do {                    
                    System.out.println("Introduzca matrícula del vehículo:");
                    matricula = entrada.next();
                    validaMatricula(matricula);
                    if(matCorrecta==false){
                        System.out.println(textoError);
                    }
                } while (matCorrecta==false);
                do {
                    System.out.println("Introduzca tipo de vehículo: ");
                    System.out.println("Las opciones disponibles son: ");
                    bucleTipoVeh(tipoVeh);
                    tipo = entrada.next();
                    validaTipoV(tipoVeh, tipo);
                } while (!tipoVCorrecto);

                System.out.println("Introduzca los años que tiene el vehículo: ");
                anyos = entrada.nextInt();
                System.out.println("Introduzca color del vehículo: ");
                color = entrada.next();

                Vehiculo unVehiculo = new Vehiculo(marca, modelo, matricula, tipo, anyos, color);
                

                if (unVehVacio.registrarVehiculo(unVehiculo)) {
                    System.out.println("El vehículo ha sido registrado");
                    
                    unVehVacio.listarVehRegistrados();
                    
                } else {
                    System.out.println("Error. El vehículo no ha sido registrado.");
                }
                break;
            case "PERSONA":

                break;
            case "VIVIENDA":

                break;
            default:
                System.out.println("La opción introducida no es válida.");
        }

    } while (opcionCorrecta == false);
        
    } // Cierro Main
    

    /**
     * Función para validad que la opción introducida por el usuario coincide
     * con alguno de los valores aceptados por el programa
     *
     * @param opciones: Array que contiene los valores aceptados
     * @param option: variable de tipo String que contiene el valor introducido
     * por el usuario
     * @return true si el valor introducido por el usuario es válido o false si
     * no lo es.
     */
    
    public static boolean validaOpcion(String[] opciones, String option) {
        

        if (opcionCorrecta==false) {
            for (int i = 0; i < opciones.length; i++) {
                if (opciones[i].equalsIgnoreCase(option)) {
                    opcionCorrecta = true;
                }
            }
        }
        return opcionCorrecta;
    }

    /**
     * Método que recorre y muestra el contenido del array opciones
     *
     * @param opciones
     */
    public static void bucleOpciones(String[] opciones) {
        for (int i = 0; i < opciones.length; i++) {
            System.out.println(opciones[i]);
        }
    }

    public static boolean validaMatricula(String matr) {

        String textoError = "La opción introducida no es válida. Por favor, "
                + "introduzca una opción válida";

        if (matr.length() >= 7 && matr.length() <= 8) {
            matCorrecta = true;
        }
        return matCorrecta;
    }

    public static void bucleTipoVeh(String[] tipoVeh) {
        for (int i = 0; i < tipoVeh.length; i++) {
                    if (i<tipoVeh.length-1){
                        System.out.printf(tipoVeh[i] + ", ");                        
                    }else{
                        System.out.printf(tipoVeh[i] + ". ");  
                    }
                    
        }
        System.out.println("");
    }

    public static boolean validaTipoV(String[] tipoV, String tipo) {

        String textoError = "La opción introducida no es válida. Por favor, "
                + "introduzca una opción válida";

        if (!tipoVCorrecto) {
            for (int i = 0; i < tipoVeh.length; i++) {
                if (tipoVeh[i].equalsIgnoreCase(tipo)) {
                    tipoVCorrecto = true;
                }
            }
        }
        return tipoVCorrecto;

    }

}
