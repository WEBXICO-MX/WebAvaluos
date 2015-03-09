/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.blogspot.webxico.model;

import java.io.Serializable;

public class ObraComplementaria implements Serializable {

    private int id_obra;
    private String nombre_obra;
    private boolean activo;

    public ObraComplementaria() {
    }

    public ObraComplementaria(int id_obra, String nombre_obra, boolean activo) {
        this.id_obra = id_obra;
        this.nombre_obra = nombre_obra;
        this.activo = activo;
    }

    public int getId_obra() {
        return id_obra;
    }

    public void setId_obra(int id_obra) {
        this.id_obra = id_obra;
    }

    public String getNombre_obra() {
        return nombre_obra;
    }

    public void setNombre_obra(String nombre_obra) {
        this.nombre_obra = nombre_obra;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "ObraComplementaria{" + "id_obra=" + id_obra + ", nombre_obra=" + nombre_obra + ", activo=" + activo + '}';
    }

}
