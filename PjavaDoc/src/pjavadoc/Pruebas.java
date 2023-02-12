package pjavadoc;

import java.util.Scanner;

public class Pruebas {
    public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
        System.out.println("meter fecha");
        Double fecha = entrada.nextDouble();
        System.out.println(fecha);
        System.out.println(Long.MAX_VALUE);
    /*
    System.out.println("meter fecha");
        String fecha = entrada.next();


        if(validaFecha(fecha)){
            System.out.println("bien");
        }else {
            System.out.println("mal");
        }
*/
    }

    private static boolean validaFecha(String fecha) {
        if (fecha.contains("/")) {
            String[] data = fecha.split("/");
            String dia = data[0];
            String mes = data[1];
            String anyo = data[2];
            if(data.length > 3
                    || !IsInteger(dia) || Integer.valueOf(dia) <1 || Integer.valueOf(dia) >31
                    || !IsInteger(mes) || Integer.valueOf(mes) <1 || Integer.valueOf(mes) >12
                    || !IsInteger(anyo)|| Integer.valueOf(anyo) >2023    ){
                return false;
            }
            return true;
        }
        return false;
    }

    public static boolean IsInteger(String text) {
        int v;
        try {
            v = Integer.parseInt(text);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
