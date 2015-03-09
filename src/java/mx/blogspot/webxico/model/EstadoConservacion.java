/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.blogspot.webxico.model;

import java.io.Serializable;

public class EstadoConservacion implements Serializable {

    private int id_estado_conservacion;
    private String nombre_estado;
    private boolean activo;

    public EstadoConservacion() {
    }

    public EstadoConservacion(int id_estado_conservacion, String nombre_estado, boolean activo) {
        this.id_estado_conservacion = id_estado_conservacion;
        this.nombre_estado = nombre_estado;
        this.activo = activo;
    }

    public int getId_estado_conservacion() {
        return id_estado_conservacion;
    }

    public void setId_estado_conservacion(int id_estado_conservacion) {
        this.id_estado_conservacion = id_estado_conservacion;
    }

    public String getNombre_estado() {
        return nombre_estado;
    }

    public void setNombre_estado(String nombre_estado) {
        this.nombre_estado = nombre_estado;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "EstadoConservacion{" + "id_estado_conservacion=" + id_estado_conservacion + ", nombre_estado=" + nombre_estado + ", activo=" + activo + '}';
    }

}
