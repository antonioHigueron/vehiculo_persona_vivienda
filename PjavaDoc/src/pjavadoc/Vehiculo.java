/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pjavadoc;

import java.util.HashMap;
import java.util.Map;

/**
 * Sección de gestión para el registro de vehículos
 * @author Piedad
 */
public class Vehiculo {
    
    private String marca;
    private String modelo;
    private String matricula;
    private String tipo;
    private int anyos;
    private String color;
    
    
    private Map<String, Vehiculo> registraVehiculoMap = new HashMap<>();

    public Vehiculo() {
    }
    
    

    public Vehiculo(String marca, String modelo, String matricula, String tipo, int anyos, String color) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.tipo = tipo;
        this.anyos = anyos;
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getTipo() {
        return tipo;
    }

    public int getAnyos() {
        return anyos;
    }

    public String getColor() {
        return color;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public void setAnyos(int anyos) {
        this.anyos = anyos;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "marca=" + marca + ", modelo=" + modelo + ", matricula=" + matricula + ", tipo=" + tipo + ", anyos=" + anyos + ", color=" + color + '}';
    }
    
    
    public boolean buscarVehiculo(String mat) {
        return registraVehiculoMap.containsKey(mat);
    }
    
    public boolean registrarVehiculo(Vehiculo unVehiculo){
        boolean vehRegistrado=false;
        if(!buscarVehiculo(matricula)){
            registraVehiculoMap.put(matricula, unVehiculo);
            vehRegistrado=true;
        }
        return vehRegistrado;
    }
    
    public void listarVehRegistrados(){
        for (Map.Entry<String, Vehiculo> entrada : registraVehiculoMap.entrySet()) {
            Vehiculo v = entrada.getValue();
            //String miVariable = entrada.getValue();
            System.out.println( ""+ v);
        }
    }
    
    /*
    public boolean registrarVehiculo(String marca, String modelo, String matricula, String tipo, int anyos, String color){
        boolean vehRegistrado=false;
        if(!buscarVehiculo(matricula)){
            Vehiculo nVeh = new Vehiculo(marca, modelo, matricula, tipo, anyos, color);
            registraVehiculoMap.put(matricula, nVeh);
            vehRegistrado=true;
        }
        return vehRegistrado;
    }
*/

    
    
    
    
}
