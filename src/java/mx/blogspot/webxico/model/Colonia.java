/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.blogspot.webxico.model;

import java.io.Serializable;
import java.util.Calendar;
import mx.blogspot.webxico.comun.ErrorSistema;
import mx.blogspot.webxico.comun.Resultados;
import mx.blogspot.webxico.comun.UtilDB;
import mx.blogspot.webxico.comun.Utilerias;

public class Colonia implements Serializable {

    private int id_colonia;
    private Municipio id_municipio;
    private String nombre_colonia;
    private Calendar fecha_registro;
    private boolean activo;
    private boolean _existe;

    public Colonia() {
        limpiar();
    }

    public Colonia(int id_colonia) {
        limpiar();
        this.id_colonia = id_colonia;
        cargar();
    }

    public Colonia(int id_colonia, Municipio id_municipio, String nombre_colonia, Calendar fecha_registro, boolean activo) {
        this.id_colonia = id_colonia;
        this.id_municipio = id_municipio;
        this.nombre_colonia = nombre_colonia;
        this.fecha_registro = fecha_registro;
        this.activo = activo;
    }

    private void limpiar() {
        this.id_colonia = 0;
        this.id_municipio = null;
        this.nombre_colonia = "";
        this.fecha_registro = null;
        this.activo = false;
        this._existe = false;
    }

    public int getId_colonia() {
        return id_colonia;
    }

    public void setId_colonia(int id_colonia) {
        this.id_colonia = id_colonia;
    }

    public Municipio getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(Municipio id_municipio) {
        this.id_municipio = id_municipio;
    }

    public String getNombre_colonia() {
        return nombre_colonia;
    }

    public void setNombre_colonia(String nombre_colonia) {
        this.nombre_colonia = nombre_colonia;
    }

    public Calendar getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Calendar fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Colonia{" + "id_colonia=" + id_colonia + ", id_municipio=" + id_municipio + ", nombre_colonia=" + nombre_colonia + ", fecha_registro=" + fecha_registro + ", activo=" + activo + '}';
    }

    public ErrorSistema grabar() {
        ErrorSistema err;
        StringBuilder sql;
        if (!_existe) {
            this.id_colonia = UtilDB.getSiguienteNumero("colonias", "id_colonia");
            sql = new StringBuilder(" INSERT INTO colonia (id_colonia, id_municipio,nombre_colonia,fecha_registro,activo ) VALUES (");
            sql.append(this.id_colonia).append(", ");
            sql.append(this.id_municipio.getId_municipio()).append(", ");
            sql.append(Utilerias.CadenaEncomillada(this.nombre_colonia)).append(", ");
            sql.append("GETDATE()").append(",");
            sql.append(activo ? "1" : "0").append(") ");
            err = UtilDB.ejecutaSQL(sql.toString());
            if (err.getNumeroError() == 0) {
                _existe = true;
            }
        } else {
            sql = new StringBuilder(" UPDATE colonias SET ");
            sql.append("id_municipio = ").append(this.id_municipio.getId_municipio()).append(",");
            sql.append("nombre_colonia = ").append(Utilerias.CadenaEncomillada(this.nombre_colonia)).append(",");
            sql.append("activo = ").append(activo ? "1" : "0");
            sql.append(" WHERE id_colonia = ").append(this.id_colonia);
            err = UtilDB.ejecutaSQL(sql.toString());
        }
        return err;
    }

    private void cargar() {
        String sql = "SELECT * FROM colonias WHERE id_colonia =" + this.id_colonia;
        Resultados rst = UtilDB.ejecutaConsulta(sql);
        if (rst.next()) {
            cargar(rst);
        }
        rst.close();
    }

    private void cargar(Resultados rst) {
        this.id_colonia = rst.getInt("id_colonia");
        this.id_municipio = new Municipio(rst.getInt("id_municipio"));
        this.nombre_colonia = rst.getString("nombre_colonia");
        this.fecha_registro = rst.getCalendar("fecha_registro");
        this.activo = rst.getBoolean("activo");
        this._existe = true;
    }

}
