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

public class Proposito implements Serializable {

    private int id_proposito;
    private String descripcion_proposito;
    private boolean activo;
    private boolean _existe;

    public Proposito() {
        limpiar();
    }

    public Proposito(int id_proposito) {
        limpiar();
        this.id_proposito = id_proposito;
        cargar();
    }

    public Proposito(int id_proposito, String descripcion_proposito, boolean activo) {
        this.id_proposito = id_proposito;
        this.descripcion_proposito = descripcion_proposito;
        this.activo = activo;
    }

    private void limpiar() {
        this.id_proposito = 0;
        this.descripcion_proposito = "";
        this.activo = false;
        this._existe = false;
    }

    public int getId_proposito() {
        return id_proposito;
    }

    public void setId_proposito(int id_proposito) {
        this.id_proposito = id_proposito;
    }

    public String getDescripcion_proposito() {
        return descripcion_proposito;
    }

    public void setDescripcion_proposito(String descripcion_proposito) {
        this.descripcion_proposito = descripcion_proposito;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Proposito{" + "id_proposito=" + id_proposito + ", descripcion_proposito=" + descripcion_proposito + ", activo=" + activo + '}';
    }

    public ErrorSistema grabar() {
        ErrorSistema err;
        StringBuilder sql;

        if (!this._existe) {
            this.id_proposito = UtilDB.getSiguienteNumero("Propositos", "id_proposito");
            sql = new StringBuilder("INSERT INTO Propositos VALUES(");
            sql.append(this.id_proposito).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.descripcion_proposito)).append(",");
            sql.append(this.activo ? "1" : "0");
            sql.append(")");
            err = UtilDB.ejecutaSQL(sql.toString());
            if (err.getNumeroError() == 0) {
                this._existe = true;
            }
        } else {
            sql = new StringBuilder("UPDATE Propositos SET ");
            sql.append("descripcion_proposito=").append(Utilerias.CadenaEncomillada(this.descripcion_proposito)).append(",");
            sql.append("activo=").append(this.activo ? "1" : "0");
            sql.append(" WHERE id_proposito=").append(this.id_proposito);
            err = UtilDB.ejecutaSQL(sql.toString());
        }

        return err;
    }

    private void cargar() {
        String sql = "SELECT * FROM Propositos WHERE id_proposito=" + this.id_proposito;
        Resultados rst = UtilDB.ejecutaConsulta(sql);
        if (rst.next()) {
            cargar(rst);
        }
        rst.close();
    }

    private void cargar(Resultados rst) {
        this.id_proposito = rst.getInt("id_proposito");
        this.descripcion_proposito = rst.getString("descripcion_proposito");
        this.activo = rst.getBoolean("activo");
        this._existe = true;
    }
}
