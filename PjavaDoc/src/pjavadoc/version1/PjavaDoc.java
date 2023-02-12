package pjavadoc.version1;


import java.util.Date;
import java.util.Scanner;

import static pjavadoc.version1.Persona.listarPersonasRegistradas;
import static pjavadoc.version1.Vehiculo.listarVehRegistrados;
import static pjavadoc.version1.Vivienda.listarViviendaRegistradas;

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
    public static String textoError = "La opción introducida no es válida. Por favor, introduzca una opción válida";

    /**
     * The constant entrada.
     */
    public static Scanner entrada = new Scanner(System.in);

    /**
     * The constant option.
     */
    public static String option;
    /**
     * The constant opciones.
     */
    public static String[] opciones = {"VIVIENDA", "VEHICULO", "PERSONA"};
    /**
     * The constant tipoVeh.
     */
    public static String[] tipoVeh = {"turismo", "todoterreno", "sub", "comercial", "motocicleta", "ciclomotor", "agrícola", "camión", "autobús"};

    public static String[] tipoVivienda = {"APARTAMENTO", "LOFT", "PISO", "CASA"};

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        System.out.println("***********************************");
        System.out.println("Programa de registro de información");
        System.out.println("***********************************");

        do {
            getOption();

            switch (option) {
                case "VEHICULO":
                    registrarVehiculo();
                    break;
                case "PERSONA":
                    registrarPersona();
                    break;
                case "VIVIENDA":
                    registrarVivienda();
                    break;
                case "0":
                    break;
                default:
                    System.out.println("La opción introducida no es válida.");
            }

        } while (!option.equals("0"));
    } // Cierro Main

    private static void getOption() {
        System.out.println("¿Qué información quiere registrar?");
        System.out.println("Las opciones disponibles son: ");
        bucleOpciones(opciones);
        System.out.println("Pulse 0 para salir");
        option = entrada.nextLine();
        if (validaOpcion(opciones, option)) {
            option = option.toUpperCase();
        }
    }

    //---------------------------------------------------------------VIVIENDA
    private static void registrarVivienda() {
        String direccion, provincia, tipo, refCatastral;
        double metros;
        int cp;
        boolean terraza, cochera, piscina;
        direccion = getValue("Introduzca direccion:");
        metros = getValueDouble("Inserte los metros");
        cp = getValueInt("Introduzca codigo postal:");
        provincia = getValue("Introduzca provincia");
        tipo = getTipoVivienda();
        refCatastral = getValue("Introduzca referencia catastral:");
        terraza = getValueBoolean("Tiene terraza (S/N)");
        cochera = getValueBoolean("Tiene cochera (S/N)");
        piscina = getValueBoolean("Tiene piscina (S/N)");

        Vivienda vivienda = new Vivienda(direccion, metros, cp, provincia, tipo,  refCatastral,terraza, cochera, piscina);
        if (Vivienda.registrarVivienda(vivienda)) {
            System.out.println("La vivienda ha sido registrada");
        } else {
            System.out.println("Error. La vivienda no ha sido registrada.");
        }
        listarViviendaRegistradas();
    }

    //---------------------------------------------------------------PERSONA
    private static void registrarPersona() {
        String nombreApellidos, dni, profesion;
        char sexo;
        double altura;
        int edad, salario;
        long telefono;
        Date fechaNacimiento;
        nombreApellidos = getValue("Introduzca nombre y apellidos:");
        edad = getValueInt("Introduzca edad:");
        dni = getDni();
        fechaNacimiento = getFechaNacimiento();
        telefono = getTelefono();
        profesion = getValue("Introduzca profesion");
        altura = getValueDouble("Inserte la altura");
        sexo = getSexo();
        salario = getValueInt("Introduzca salario");
        Persona persona = new Persona(nombreApellidos, edad, dni, fechaNacimiento, telefono, profesion, altura, sexo, salario);
        if (Persona.registrarPersona(persona)) {
            System.out.println("La persona ha sido registrada");
        } else {
            System.out.println("Error. La persona no ha sido registrada.");
        }
        listarPersonasRegistradas();
    }

    private static char getSexo() {
        String valor;
        do {
            System.out.println("Ingrese el sexo, formato (H/M)");
            valor = entrada.nextLine();
        } while (!IsChar(valor));
        return valor.charAt(0);
    }

    private static boolean getValueBoolean(String x) {
        String valor;
        boolean bandera=true;
        do {
            System.out.println(x);
            valor = entrada.nextLine();
            if (valor.length()== 1 && (valor.equalsIgnoreCase("S") || valor.equalsIgnoreCase("N"))){
                bandera = false;
            }
        } while (bandera);
        if (valor.equalsIgnoreCase("s")){
            return true;
        }else{
            return false;
        }
    }

    public static boolean IsChar(String text) {
        try {
            return text.length() == 1 && (text.equalsIgnoreCase("H") || text.equalsIgnoreCase("M"));
        } catch (Exception ex) {
            return false;
        }
    }

    private static Double getValueDouble(String x) {
        String valor;
        do {
            System.out.println(x);
            valor = entrada.nextLine();
        } while (!IsDouble(valor));
        return Double.valueOf(valor);
    }

    public static boolean IsDouble(String text) {
        try {
            Double.parseDouble(text);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }


    private static long getTelefono() {
        String valor;
        do {
            System.out.println("Introduce numero de telefono");
            valor = entrada.nextLine();
        } while (!IsLong(valor) && !validarLongitud(valor));
        return Long.parseLong(valor);
    }

    private static boolean validarLongitud(String telefono) {
        return telefono.length() == 13;
    }


    private static Date getFechaNacimiento() {
        String fecha;
        boolean validado;
        do {
            fecha = getValue("Introduzca fecha nacimiento con formato dd/MM/yyyy o  dd/MM/yy");
            validado = validaFecha(fecha);
            if (!validado) {
                System.out.println(textoError);
            }
        } while (!validado);
        String[] fechaArray = fecha.split("/");
        int[] datos = new int[3];
        for (int i = 0; i < datos.length; i++) {
            datos[i] = Integer.parseInt(fechaArray[i]);
        }
        return new Date(datos[0], datos[1], datos[2]);
    }

    private static boolean validaFecha(String fecha) {
        if (fecha.contains("/")) {
            String[] data = fecha.split("/");
            String dia = data[0];
            String mes = data[1];
            String anyo = data[2];
            return data.length <= 3
                    && IsInteger(dia) && Integer.parseInt(dia) >= 1 && Integer.parseInt(dia) <= 31
                    && IsInteger(mes) && Integer.parseInt(mes) >= 1 && Integer.parseInt(mes) <= 12
                    && IsInteger(anyo) && Integer.parseInt(anyo) <= 2023;
        }
        return false;
    }

    private static String getDni() {
        String dni;
        boolean validado;
        do {
            dni = getValue("Introduzca dni de la persona:");
            validado = validaDni(dni);
            if (!validado) {
                System.out.println(textoError);
            }
        } while (!validado);
        return dni;
    }

    private static boolean validaDni(String dni) {
        return dni.length() == 9;
    }

    //--------------------------------------------------------------------------------VEHICULO
    private static void registrarVehiculo() {
        String marca, modelo, matricula, tipo, color;
        int anyos;
        marca = getValue("Introduzca marca del vehículo:");
        modelo = getValue("Introduzca modelo del vehículo:");
        matricula = getMatricula();
        tipo = getTipo();
        anyos = getValueInt("Introduzca los años que tiene el vehículo: ");
        color = getValue("Introduzca color del vehículo: ");
        Vehiculo vehiculo = new Vehiculo(marca, modelo, matricula, tipo, anyos, color);
        if (Vehiculo.registrarVehiculo(vehiculo)) {
            System.out.println("El vehículo ha sido registrado");
        } else {
            System.out.println("Error. El vehículo no ha sido registrado.");
        }
        listarVehRegistrados();
    }

    private static String getTipo() {
        String tipo;
        do {
            System.out.println("Introduzca tipo de vehículo: ");
            System.out.println("Las opciones disponibles son: ");
            bucleTipoVeh(tipoVeh);
            tipo = entrada.nextLine();
            if (validaTipoV(tipo)) {
                System.out.println(textoError);
            }
        } while (validaTipoV(tipo));
        return tipo;
    }

    private static String getTipoVivienda() {
        String tipo;
        do {
            System.out.println("Introduzca tipo de vivienda: ");
            System.out.println("Las opciones disponibles son: ");
            bucleTipoVivienda();
            tipo = entrada.nextLine();
            if (!validaTipoVivienda(tipo)) {
                System.out.println(textoError);
            }
        } while (!validaTipoVivienda(tipo));
        return tipo;
    }

    private static String getMatricula() {
        String matricula;
        do {
            matricula = getValue("Introduzca matricula del vehículo:");
            if (validaMatricula(matricula)) {
                System.out.println(textoError);
            }
        } while (validaMatricula(matricula));
        return matricula;
    }

    private static String getValue(String x) {
        String valor;
        System.out.println(x);
        valor = entrada.nextLine();
        return valor;
    }

    private static int getValueInt(String x) {
        String valor;
        do {
            System.out.println(x);
            valor = entrada.nextLine();
        } while (!IsInteger(valor));
        return Integer.parseInt(valor);
    }

    public static boolean IsInteger(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static boolean IsLong(String text) {
        try {
            Long.valueOf(text);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * Función para validad que la opción introducida por el usuario coincide
     * con alguno de los valores aceptados por el programa
     *
     * @param opciones : Array que contiene los valores aceptados
     * @param option   : variable de tipo String que contiene el valor introducido por el usuario
     * @return true si el valor introducido por el usuario es válido o false si no lo es.
     */
    public static boolean validaOpcion(String[] opciones, String option) {
        for (String opcione : opciones) {
            if (opcione.equalsIgnoreCase(option)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método que recorre y muestra el contenido del array opciones
     *
     * @param opciones the opciones
     */
    public static void bucleOpciones(String[] opciones) {
        for (String opcione : opciones) {
            System.out.println(opcione);
        }
    }

    /**
     * Valida matricula boolean.
     *
     * @param matr the matr
     * @return the boolean
     */
    public static boolean validaMatricula(String matr) {
        return matr.length() < 7 || matr.length() > 8;
    }

    /**
     * Bucle tipo veh.
     *
     * @param tipoVeh the tipo veh
     */
    public static void bucleTipoVeh(String[] tipoVeh) {
        for (int i = 0; i < tipoVeh.length; i++) {
            if (i < tipoVeh.length - 1) {
                System.out.print(tipoVeh[i] + ", ");
            } else {
                System.out.println(tipoVeh[i] + ". ");
            }
        }
    }

    public static void bucleTipoVivienda() {
        for (int i = 0; i < tipoVivienda.length; i++) {
            if (i < tipoVivienda.length - 1) {
                System.out.print(tipoVivienda[i] + ", ");
            } else {
                System.out.println(tipoVivienda[i] + ". ");
            }
        }
    }

    /**
     * Valida tipo v boolean.
     *
     * @param tipo the tipo
     * @return the boolean
     */
    public static boolean validaTipoV(String tipo) {
        for (String s : tipoVeh) {
            if (s.equalsIgnoreCase(tipo)) {
                return false;
            }
        }
        return true;
    }

    public static boolean validaTipoVivienda(String tipo) {
        for (String s : tipoVivienda) {
            if (s.equalsIgnoreCase(tipo)) {
                return true;
            }
        }
        return false;
    }
//---------------------------------------------------------------------------
}
