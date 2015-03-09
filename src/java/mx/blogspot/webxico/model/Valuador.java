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

public class Valuador implements Serializable {

    private Persona id_valuador;
    private String ruta_constancia;
    private String cedula_profesional_valuador;
    private String registro_estatal;
    private String registro_colegio;
    private Calendar fecha_registro;
    private boolean activo;
    private boolean _existe;

    public Valuador() {
        limpiar();
    }

    public Valuador(Persona id_valuador) {
        limpiar();
        this.id_valuador = id_valuador;
        cargar();
    }

    public Valuador(Persona id_valuador, String ruta_constancia, String cedula_profesional_valuador, String registro_estatal, String registro_colegio, Calendar fecha_registro, boolean activo) {
        this.id_valuador = id_valuador;
        this.ruta_constancia = ruta_constancia;
        this.cedula_profesional_valuador = cedula_profesional_valuador;
        this.registro_estatal = registro_estatal;
        this.registro_colegio = registro_colegio;
        this.fecha_registro = fecha_registro;
        this.activo = activo;
    }

    private void limpiar() {
        this.id_valuador = null;
        this.ruta_constancia = "";
        this.cedula_profesional_valuador = "";
        this.registro_estatal = "";
        this.registro_colegio = "";
        this.fecha_registro = null;
        this.activo = false;
        this._existe = false;
    }

    public Persona getId_valuador() {
        return id_valuador;
    }

    public void setId_valuador(Persona id_valuador) {
        this.id_valuador = id_valuador;
    }

    public String getRuta_constancia() {
        return ruta_constancia;
    }

    public void setRuta_constancia(String ruta_constancia) {
        this.ruta_constancia = ruta_constancia;
    }

    public String getCedula_profesional_valuador() {
        return cedula_profesional_valuador;
    }

    public void setCedula_profesional_valuador(String cedula_profesional_valuador) {
        this.cedula_profesional_valuador = cedula_profesional_valuador;
    }

    public String getRegistro_estatal() {
        return registro_estatal;
    }

    public void setRegistro_estatal(String registro_estatal) {
        this.registro_estatal = registro_estatal;
    }

    public String getRegistro_colegio() {
        return registro_colegio;
    }

    public void setRegistro_colegio(String registro_colegio) {
        this.registro_colegio = registro_colegio;
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
        return "Valuador{" + "id_valuador=" + id_valuador + ", ruta_constancia=" + ruta_constancia + ", cedula_profesional_valuador=" + cedula_profesional_valuador + ", registro_estatal=" + registro_estatal + ", registro_colegio=" + registro_colegio + ", fecha_registro=" + fecha_registro + ", activo=" + activo + '}';
    }

    public ErrorSistema grabar() {
        ErrorSistema err;
        StringBuilder sql;

        if (!this._existe) {
            sql = new StringBuilder("INSERT INTO Valuadores VALUES(");
            sql.append(this.id_valuador.getId_persona()).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.ruta_constancia)).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.cedula_profesional_valuador)).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.registro_estatal)).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.registro_colegio)).append(",");
            sql.append("GETDATE()").append(",");
            sql.append(this.activo ? "1" : "0");
            sql.append(")");
            err = UtilDB.ejecutaSQL(sql.toString());
            if (err.getNumeroError() == 0) {
                this._existe = true;
            }
        } else {
            sql = new StringBuilder("UPDATE Valuadores SET ");
            sql.append("ruta_constancia = ").append(this.ruta_constancia).append(",");
            sql.append("cedula_profesional_valuador = ").append(this.cedula_profesional_valuador).append(",");
            sql.append("registro_estatal = ").append(this.registro_estatal).append(",");
            sql.append("registro_colegio = ").append(this.registro_colegio).append(",");
            sql.append("activo = ").append(this.activo ? "1" : "0");
            sql.append(" WHERE id_valuador = ").append(this.id_valuador.getId_persona());
            err = UtilDB.ejecutaSQL(sql.toString());
        }
        return err;
    }

    private void cargar() {
        String sql = "SELECT * FROM Valuadores WHERE id_valuador = " + this.id_valuador.getId_persona();
        Resultados rst = UtilDB.ejecutaConsulta(sql);
        if (rst.next()) {
            cargar(rst);
        }
        rst.close();

    }

    private void cargar(Resultados rst) {
        this.id_valuador = new Persona(rst.getInt("id_valuador"));
        this.ruta_constancia = rst.getString("ruta_constancia");
        this.cedula_profesional_valuador = rst.getString("cedula_profesional_valuador");
        this.registro_estatal = rst.getString("registro_estatal");
        this.registro_colegio = rst.getString("registro_colegio");
        this.fecha_registro = rst.getCalendar("fecha_registro");
        this.activo = rst.getBoolean("activo");
        this._existe = true;
    }
}
