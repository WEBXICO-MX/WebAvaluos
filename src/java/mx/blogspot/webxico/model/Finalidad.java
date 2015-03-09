/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.blogspot.webxico.model;

import java.io.Serializable;
import mx.blogspot.webxico.comun.ErrorSistema;
import mx.blogspot.webxico.comun.Resultados;
import mx.blogspot.webxico.comun.UtilDB;
import mx.blogspot.webxico.comun.Utilerias;

public class Finalidad implements Serializable {

    private int id_finalidad;
    private String descripcion_finalidad;
    private boolean activo;
    private boolean _existe;

    public Finalidad() {
        limpiar();
    }

    public Finalidad(int id_finalidad) {
        limpiar();
        this.id_finalidad = id_finalidad;
        cargar();
    }

    public Finalidad(int id_finalidad, String descripcion_finalidad, boolean activo) {
        this.id_finalidad = id_finalidad;
        this.descripcion_finalidad = descripcion_finalidad;
        this.activo = activo;
    }

    private void limpiar() {
        this.id_finalidad = 0;
        this.descripcion_finalidad = "";
        this.activo = false;
        this._existe = false;
    }

    public int getId_finalidad() {
        return id_finalidad;
    }

    public void setId_finalidad(int id_finalidad) {
        this.id_finalidad = id_finalidad;
    }

    public String getDescripcion_finalidad() {
        return descripcion_finalidad;
    }

    public void setDescripcion_finalidad(String descripcion_finalidad) {
        this.descripcion_finalidad = descripcion_finalidad;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Finalidad{" + "id_finalidad=" + id_finalidad + ", descripcion_finalidad=" + descripcion_finalidad + ", activo=" + activo + '}';
    }

    public ErrorSistema grabar() {
        ErrorSistema err;
        StringBuilder sql;

        if (!this._existe) {
            this.id_finalidad = UtilDB.getSiguienteNumero("Finalidades", "id_finalidad");
            sql = new StringBuilder("INSERT INTO Finalidades VALUES(");
            sql.append(this.id_finalidad).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.descripcion_finalidad)).append(",");
            sql.append(this.activo ? "1" : "0");
            sql.append(")");
            err = UtilDB.ejecutaSQL(sql.toString());
            if (err.getNumeroError() == 0) {
                this._existe = true;
            }
        } else {
            sql = new StringBuilder("UPDATE Finalidades SET ");
            sql.append("descripcion_finalidad= ").append(Utilerias.CadenaEncomillada(this.descripcion_finalidad)).append(",");
            sql.append("activo=").append(this.activo ? "1" : "0");
            sql.append(" WHERE id_finalidad = ").append(this.id_finalidad);
            err = UtilDB.ejecutaSQL(sql.toString());
        }

        return err;
    }

    private void cargar() {
        String sql = "SELECT * FROM Finalidades WHERE id_finalidad = " + this.id_finalidad;
        Resultados rst = UtilDB.ejecutaConsulta(sql);
        if (rst.next()) {
            cargar(rst);
        }
        rst.close();

    }

    private void cargar(Resultados rst) {
        this.id_finalidad = rst.getInt("id_finalidad");
        this.descripcion_finalidad = rst.getString("descripcion_finalidad");
        this.activo = rst.getBoolean("activo");
        this._existe = true;

    }

}
