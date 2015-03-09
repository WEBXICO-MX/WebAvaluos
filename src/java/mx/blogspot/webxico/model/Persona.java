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

public class Persona implements Serializable {

    private int id_persona;
    private String nombre;
    private String ap_paterno;
    private String ap_materno;
    private Calendar fecha_nacimiento;
    private Calendar fecha_registro;
    private boolean activo;
    private boolean _existe;

    public Persona() {
        limpiar();
    }

    public Persona(int id_persona) {
        limpiar();
        this.id_persona = id_persona;
        cargar();
    }

    public Persona(int id_persona, String nombre, String ap_paterno, String ap_materno, Calendar fecha_nacimiento, Calendar fecha_registro, boolean activo) {
        this.id_persona = id_persona;
        this.nombre = nombre;
        this.ap_paterno = ap_paterno;
        this.ap_materno = ap_materno;
        this.fecha_nacimiento = fecha_nacimiento;
        this.fecha_registro = fecha_registro;
        this.activo = activo;
    }

    private void limpiar() {
        this.id_persona = 0;
        this.nombre = "";
        this.ap_paterno = "";
        this.ap_materno = "";
        this.fecha_nacimiento = null;
        this.fecha_registro = null;
        this.activo = false;
        this._existe = false;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAp_paterno() {
        return ap_paterno;
    }

    public void setAp_paterno(String ap_paterno) {
        this.ap_paterno = ap_paterno;
    }

    public String getAp_materno() {
        return ap_materno;
    }

    public void setAp_materno(String ap_materno) {
        this.ap_materno = ap_materno;
    }

    public Calendar getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Calendar fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
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
        return "Persona{" + "id_persona=" + id_persona + ", nombre=" + nombre + ", ap_paterno=" + ap_paterno + ", ap_materno=" + ap_materno + ", fecha_nacimiento=" + fecha_nacimiento + ", fecha_registro=" + fecha_registro + ", activo=" + activo + '}';
    }

    public ErrorSistema grabar() {
        ErrorSistema err;
        StringBuilder sql;
        if (!_existe) {
            this.id_persona = UtilDB.getSiguienteNumero("personas", "id_persona");
            sql = new StringBuilder("INSERT INTO personas VALUES(");
            sql.append(this.id_persona).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.nombre)).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.ap_paterno)).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.ap_materno)).append(",");
            sql.append(Utilerias.formatoFechaDB(this.fecha_nacimiento)).append(",");
            sql.append("GETDATE()").append(",");
            sql.append(this.activo ? "1" : "2");
            sql.append(")");
            err = UtilDB.ejecutaSQL(sql.toString());
            if (err.getNumeroError() == 0) {
                this._existe = true;
            }
        } else {
            sql = new StringBuilder("UPDATE personas SET ");
            sql.append("nombre = ").append(Utilerias.CadenaEncomillada(this.nombre)).append(",");
            sql.append("ap_paterno = ").append(Utilerias.CadenaEncomillada(this.ap_paterno)).append(",");
            sql.append("ap_materno = ").append(Utilerias.CadenaEncomillada(this.ap_materno)).append(",");
            sql.append("fecha_nacimiento = ").append(Utilerias.formatoFechaDB(this.fecha_nacimiento)).append(",");
            sql.append("activo = ").append(this.activo ? "1" : "0");
            sql.append(" WHERE id_persona = ").append(this.id_persona);
            err = UtilDB.ejecutaSQL(sql.toString());
        }
        return err;
    }

    private void cargar() {
        String sql = "SELECT * FROM personas WHERE id_persona =" + this.id_persona;
        Resultados rst = UtilDB.ejecutaConsulta(sql);
        if (rst.next()) {
            cargar(rst);
        }
        rst.close();
    }

    private void cargar(Resultados rst) {
        this.id_persona = rst.getInt("id_persona");
        this.nombre = rst.getString("nombre");
        this.ap_paterno = rst.getString("ap_paterno");
        this.ap_materno = rst.getString("ap_materno");
        this.fecha_nacimiento = rst.getCalendar("fecha_nacimiento");
        this.fecha_registro = rst.getCalendar("fecha_registro");
        this.activo = rst.getBoolean("activo");
        this._existe = true;
    }

}
