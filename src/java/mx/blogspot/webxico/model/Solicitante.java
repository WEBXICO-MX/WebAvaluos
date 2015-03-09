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

public class Solicitante implements Serializable {

    private Persona id_solicitante;
    private Calendar fecha_registro;
    private boolean activo;
    private boolean _existe;

    public Solicitante() {
        limpiar();
    }

    public Solicitante(Persona id_solicitante) {
        limpiar();
        this.id_solicitante = id_solicitante;
        cargar();
    }

    public Solicitante(Persona id_solicitante, Calendar fecha_registro, boolean activo) {
        this.id_solicitante = id_solicitante;
        this.fecha_registro = fecha_registro;
        this.activo = activo;
    }

    private void limpiar() {
        this.id_solicitante = null;
        this.fecha_registro = null;
        this.activo = false;
        this._existe = false;
    }

    public Persona getId_solicitante() {
        return id_solicitante;
    }

    public void setId_solicitante(Persona id_solicitante) {
        this.id_solicitante = id_solicitante;
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
        return "Solicitante{" + "id_solicitante=" + id_solicitante + ", fecha_registro=" + fecha_registro + ", activo=" + activo + '}';
    }

    private ErrorSistema grabar() {
        ErrorSistema err;
        StringBuilder sql;
        if (!this._existe) {
            sql = new StringBuilder("INSERT INTO Solicitantes VALUES(");
            sql.append(this.id_solicitante.getId_persona()).append(",");
            sql.append("GETDATE()").append(",");
            sql.append(this.activo ? "1" : "0");
            sql.append(")");
            err = UtilDB.ejecutaSQL(sql.toString());
            if (err.getNumeroError() == 0) {
                this._existe = true;
            }
        } else {
            sql = new StringBuilder("UPDATE Solicitantes SET ");
            sql.append("activo = ").append(this.activo ? "1" : "0");
            sql.append(" WHERE id_solicitante = ").append(this.id_solicitante.getId_persona());
            err = UtilDB.ejecutaSQL(sql.toString());
        }
        return err;

    }

    private void cargar() {
        String sql = "SELECT * FROM Solicitantes WHERE id_solicitante = " + this.id_solicitante.getId_persona();
        Resultados rst = UtilDB.ejecutaConsulta(sql);
        if (rst.next()) {
            cargar(rst);
        }
        rst.close();

    }

    private void cargar(Resultados rst) {
        this.id_solicitante = new Persona(rst.getInt("id_solicitante"));
        this.fecha_registro = rst.getCalendar("fecha_registro");
        this.activo = rst.getBoolean("activo");
        this._existe = true;
    }

}
