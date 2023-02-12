package pjavadoc.version1;

import java.util.HashMap;
import java.util.Map;

/**
 * Sección de gestión para el registro de vehículos
 *
 * @author Piedad
 */
public class Vivienda {
    private String direccion;
    private double metros;
    private int cp;
    private String provincia;
    private String tipo;
    private String refCatastral;
    private boolean terraza;
    private boolean cochera;
    private boolean piscina;

    private static Map<String, Vivienda> registraViviendaMap = new HashMap<>();
    /**
     * Instantiates a new Vivienda.
     */
    public Vivienda() {
    }

    /**
     * Instantiates a new Vivienda.
     *
     * @param direccion    the direccion
     * @param metros       the metros
     * @param cp           the cp
     * @param provincia    the provincia
     * @param tipo         valores permitidos: Apartamento, Loft, Piso, Casa
     * @param refCatastral the ref catastral
     * @param terraza      the terraza
     * @param cochera      the cochera
     * @param piscina      the piscina
     */
    public Vivienda(String direccion, double metros, int cp, String provincia, String tipo, String refCatastral, boolean terraza, boolean cochera, boolean piscina) {
        this.direccion = direccion;
        this.metros = metros;
        this.cp = cp;
        this.provincia = provincia;
        this.tipo = tipo;
        this.refCatastral = refCatastral;
        this.terraza = terraza;
        this.cochera = cochera;
        this.piscina = piscina;
    }

    /**
     * Gets direccion.
     *
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Sets direccion.
     *
     * @param direccion the direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Gets metros.
     *
     * @return the metros
     */
    public double getMetros() {
        return metros;
    }

    /**
     * Sets metros.
     *
     * @param metros the metros
     */
    public void setMetros(double metros) {
        this.metros = metros;
    }

    /**
     * Gets cp.
     *
     * @return the cp
     */
    public int getCp() {
        return cp;
    }

    /**
     * Sets cp.
     *
     * @param cp the cp
     */
    public void setCp(int cp) {
        this.cp = cp;
    }

    /**
     * Gets provincia.
     *
     * @return the provincia
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * Sets provincia.
     *
     * @param provincia the provincia
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
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
     * Sets tipo.
     *
     * @param tipo the tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Gets ref catastral.
     *
     * @return the ref catastral
     */
    public String getRefCatastral() {
        return refCatastral;
    }

    /**
     * Sets ref catastral.
     *
     * @param refCatastral the ref catastral
     */
    public void setRefCatastral(String refCatastral) {
        this.refCatastral = refCatastral;
    }

    /**
     * Is terraza boolean.
     *
     * @return the boolean
     */
    public boolean isTerraza() {
        return terraza;
    }

    /**
     * Sets terraza.
     *
     * @param terraza the terraza
     */
    public void setTerraza(boolean terraza) {
        this.terraza = terraza;
    }

    /**
     * Is cochera boolean.
     *
     * @return the boolean
     */
    public boolean isCochera() {
        return cochera;
    }

    /**
     * Sets cochera.
     *
     * @param cochera the cochera
     */
    public void setCochera(boolean cochera) {
        this.cochera = cochera;
    }

    /**
     * Is piscina boolean.
     *
     * @return the boolean
     */
    public boolean isPiscina() {
        return piscina;
    }

    /**
     * Sets piscina.
     *
     * @param piscina the piscina
     */
    public void setPiscina(boolean piscina) {
        this.piscina = piscina;
    }

    /**
     * To string string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "Vivienda{" +
                "direccion='" + direccion + '\'' +
                ", metros=" + metros +
                ", cp=" + cp +
                ", provincia='" + provincia + '\'' +
                ", tipo=" + tipo +
                ", refCatastral='" + refCatastral + '\'' +
                ", terraza=" + terraza +
                ", cochera=" + cochera +
                ", piscina=" + piscina +
                '}';
    }

    public static boolean buscarVivienda(String mat) {
        return registraViviendaMap.containsKey(mat);
    }

    public static boolean registrarVivienda(Vivienda vivienda){
        if(!buscarVivienda(vivienda.getRefCatastral())){
            registraViviendaMap.put(vivienda.getRefCatastral(),vivienda);
            return true;
        }
        return false;
    }

    public static void listarViviendaRegistradas(){
        for (Map.Entry<String, Vivienda> entrada : registraViviendaMap.entrySet()) {
            Vivienda v = entrada.getValue();
            System.out.println(v);
        }
    }


}
