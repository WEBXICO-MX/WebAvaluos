/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.blogspot.webxico.model;

import java.io.Serializable;

public class CalidadProyecto implements Serializable {

    private int id_calidad_proyecto;
    private String nombre_calidad;
    private boolean activo;

    public CalidadProyecto() {
    }

    public CalidadProyecto(int id_calidad_proyecto, String nombre_calidad, boolean activo) {
        this.id_calidad_proyecto = id_calidad_proyecto;
        this.nombre_calidad = nombre_calidad;
        this.activo = activo;
    }

    public int getId_calidad_proyecto() {
        return id_calidad_proyecto;
    }

    public void setId_calidad_proyecto(int id_calidad_proyecto) {
        this.id_calidad_proyecto = id_calidad_proyecto;
    }

    public String getNombre_calidad() {
        return nombre_calidad;
    }

    public void setNombre_calidad(String nombre_calidad) {
        this.nombre_calidad = nombre_calidad;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "CalidadProyecto{" + "id_calidad_proyecto=" + id_calidad_proyecto + ", nombre_calidad=" + nombre_calidad + ", activo=" + activo + '}';
    }

}
