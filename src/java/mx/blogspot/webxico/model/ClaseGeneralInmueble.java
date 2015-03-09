/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.blogspot.webxico.model;

import java.io.Serializable;

public class ClaseGeneralInmueble implements Serializable {

    private int id_clase_general_inm;
    private String nombre_clase_general;
    private boolean activo;

    public ClaseGeneralInmueble() {
    }

    public ClaseGeneralInmueble(int id_clase_general_inm, String nombre_clase_general, boolean activo) {
        this.id_clase_general_inm = id_clase_general_inm;
        this.nombre_clase_general = nombre_clase_general;
        this.activo = activo;
    }

    public int getId_clase_general_inm() {
        return id_clase_general_inm;
    }

    public void setId_clase_general_inm(int id_clase_general_inm) {
        this.id_clase_general_inm = id_clase_general_inm;
    }

    public String getNombre_clase_general() {
        return nombre_clase_general;
    }

    public void setNombre_clase_general(String nombre_clase_general) {
        this.nombre_clase_general = nombre_clase_general;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "ClaseGeneralInmueble{" + "id_clase_general_inm=" + id_clase_general_inm + ", nombre_clase_general=" + nombre_clase_general + ", activo=" + activo + '}';
    }

}
