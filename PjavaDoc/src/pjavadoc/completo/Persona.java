package pjavadoc.completo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Sección de gestión para el registro de personas
 *
 * @author Piedad
 */
public class Persona {
    private String nomApe;
    private int edad;
    private String dni; //controlar que tenga 9 caracteres
    private Date fechaNacimiento;
    private int telefono;//longitud 13 caracteres
    private String profesion;
    private double altura;
    private char sexo; // H Hombre | M Mujer
    private int salario;

    private static Map<String, Persona> registraPersonaMap = new HashMap<>();


    /**
     * Instantiates a new Persona.
     */
    public Persona() {
    }

    /**
     * Instantiates a new Persona.
     *
     * @param nomApe          the nom ape
     * @param edad            the edad
     * @param dni             the dni
     * @param fechaNacimiento the fecha nacimiento
     * @param telefono        the telefono
     * @param profesion       the profesion
     * @param altura          the altura
     * @param sexo            the sexo
     * @param salario         the salario
     */
    public Persona(String nomApe, int edad, String dni, Date fechaNacimiento, int telefono, String profesion, double altura, char sexo, int salario) {
        this.nomApe = nomApe;
        this.edad = edad;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.profesion = profesion;
        this.altura = altura;
        this.sexo = sexo;
        this.salario = salario;
    }

    /**
     * Gets nom ape.
     *
     * @return the nom ape
     */
    public String getNomApe() {
        return nomApe;
    }

    /**
     * Sets nom ape.
     *
     * @param nomApe the nom ape
     */
    public void setNomApe(String nomApe) {
        this.nomApe = nomApe;
    }

    /**
     * Gets edad.
     *
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Sets edad.
     *
     * @param edad the edad
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Gets dni.
     *
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * Sets dni.
     *
     * @param dni the dni
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Gets fecha nacimiento.
     *
     * @return the fecha nacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Sets fecha nacimiento.
     *
     * @param fechaNacimiento the fecha nacimiento
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Gets telefono.
     *
     * @return the telefono
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * Sets telefono.
     *
     * @param telefono the telefono
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * Gets profesion.
     *
     * @return the profesion
     */
    public String getProfesion() {
        return profesion;
    }

    /**
     * Sets profesion.
     *
     * @param profesion the profesion
     */
    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    /**
     * Gets altura.
     *
     * @return the altura
     */
    public double getAltura() {
        return altura;
    }

    /**
     * Sets altura.
     *
     * @param altura the altura
     */
    public void setAltura(double altura) {
        this.altura = altura;
    }

    /**
     * Gets sexo.
     *
     * @return the sexo
     */
    public char getSexo() {
        return sexo;
    }

    /**
     * Sets sexo.
     *
     * @param sexo the sexo
     */
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    /**
     * Gets salario.
     *
     * @return the salario
     */
    public int getSalario() {
        return salario;
    }

    /**
     * Sets salario.
     *
     * @param salario the salario
     */
    public void setSalario(int salario) {
        this.salario = salario;
    }

    /**
     * To string string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "Persona{" +
                "nomApe='" + nomApe + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", telefono=" + telefono +
                ", profesion='" + profesion + '\'' +
                ", altura=" + altura +
                ", sexo=" + sexo +
                ", salario=" + salario +
                '}';
    }


    public static boolean buscarPersona(String mat) {
        return registraPersonaMap.containsKey(mat);
    }

    public static boolean registrarPersona(Persona persona){
        if(!buscarPersona(persona.getDni())){
            registraPersonaMap.put(persona.getDni(), persona);
            return true;
        }
        return false;
    }

















}
