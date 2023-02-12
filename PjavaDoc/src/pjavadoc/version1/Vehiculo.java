/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pjavadoc.version1;

import java.util.HashMap;
import java.util.Map;

/**
 * Sección de gestión para el registro de vehículos
 *
 * @author Piedad
 */
public class Vehiculo {
    
    private String marca;
    private String modelo;
    private String matricula;
    private String tipo;
    private int anyos;
    private String color;
    
    
    private static Map<String, Vehiculo> registraVehiculoMap = new HashMap<>();

    /**
     * Instantiates a new Vehiculo.
     */
    public Vehiculo() {
    }


    /**
     * Instantiates a new Vehiculo.
     *
     * @param marca     the marca
     * @param modelo    the modelo
     * @param matricula the matricula
     * @param tipo      the tipo
     * @param anyos     the anyos
     * @param color     the color
     */
    public Vehiculo(String marca, String modelo, String matricula, String tipo, int anyos, String color) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.tipo = tipo;
        this.anyos = anyos;
        this.color = color;
    }

    /**
     * Gets marca.
     *
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Gets modelo.
     *
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Gets matricula.
     *
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Gets tipo.
     *
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Gets anyos.
     *
     * @return the anyos
     */
    public int getAnyos() {
        return anyos;
    }

    /**
     * Gets color.
     *
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets marca.
     *
     * @param marca the marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Sets modelo.
     *
     * @param modelo the modelo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Sets matricula.
     *
     * @param matricula the matricula
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Sets tipo.
     *
     * @param tipo the tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    /**
     * Sets anyos.
     *
     * @param anyos the anyos
     */
    public void setAnyos(int anyos) {
        this.anyos = anyos;
    }

    /**
     * Sets color.
     *
     * @param color the color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * To string string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "Vehiculo{" + "marca=" + marca + ", modelo=" + modelo + ", matricula=" + matricula + ", tipo=" + tipo + ", anyos=" + anyos + ", color=" + color + '}';
    }


    /**
     * Buscar vehiculo boolean.
     *
     * @param mat the mat
     * @return the boolean
     */
    public static boolean buscarVehiculo(String mat) {
        return registraVehiculoMap.containsKey(mat);
    }

    /**
     * Registrar vehiculo boolean.
     *
     * @param unVehiculo the un vehiculo
     * @return the boolean
     */
    public static boolean registrarVehiculo(Vehiculo vehiculo){
        if(!buscarVehiculo(vehiculo.getMatricula())){
            registraVehiculoMap.put(vehiculo.getMatricula(), vehiculo);
            return true;
        }
        return false;
    }

    /**
     * Listar veh registrados.
     */
    public static void listarVehRegistrados(){
        for (Map.Entry<String, Vehiculo> entrada : registraVehiculoMap.entrySet()) {
            Vehiculo v = entrada.getValue();
            System.out.println( ""+ v);
        }
    }
    


    
    
    
    
}
