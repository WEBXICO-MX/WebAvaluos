/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.blogspot.webxico.model;

import java.io.Serializable;
import mx.blogspot.webxico.comun.Resultados;
import mx.blogspot.webxico.comun.UtilDB;

public class Municipio implements Serializable {

    private int id_municipio;
    private Estado id_estado;
    private String nombre_municipio;
    private boolean activo;
    private boolean _existe;

    public Municipio() {
        this.limpiar();
    }

    public Municipio(int id_municipio) {
        this.limpiar();
        this.id_municipio = id_municipio;
        cargar();
    }

    public Municipio(int id_municipio, Estado id_estado, String nombre_municipio, boolean activo) {
        this.id_municipio = id_municipio;
        this.id_estado = id_estado;
        this.nombre_municipio = nombre_municipio;
        this.activo = activo;
    }

    private void limpiar() {
        this.id_municipio = 0;
        this.id_estado = null;
        this.nombre_municipio = "";
        this.activo = false;
        this._existe = false;
    }

    public int getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(int id_municipio) {
        this.id_municipio = id_municipio;
    }

    public Estado getId_estado() {
        return id_estado;
    }

    public void setId_estado(Estado id_estado) {
        this.id_estado = id_estado;
    }

    public String getNombre_municipio() {
        return nombre_municipio;
    }

    public void setNombre_municipio(String nombre_municipio) {
        this.nombre_municipio = nombre_municipio;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Municipio{" + "id_municipio=" + id_municipio + ", id_estado=" + id_estado + ", nombre_municipio=" + nombre_municipio + ", activo=" + activo + '}';
    }

    private void cargar() {
        String sql = "select * from municipios where id_municipio = " + this.id_municipio;
        Resultados res = UtilDB.ejecutaConsulta(sql);
        if (res.next()) {
            cargar(res);
        }
        res.close();
    }

    private void cargar(Resultados res) {
        this.id_municipio = res.getInt("id_municipio");
        this.id_estado = new Estado(res.getInt("id_estado"));
        this.nombre_municipio = res.getString("nombre_municipio");
        _existe = true;
    }

}
