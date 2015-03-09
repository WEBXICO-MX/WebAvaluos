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

public class TipoInmueble implements Serializable {

    private int id_tipo_inm;
    private String nombre_tipo_inm;
    private boolean activo;
    private boolean _existe;

    public TipoInmueble() {
        limpiar();
    }

    public TipoInmueble(int id_tipo_inm) {
        limpiar();
        this.id_tipo_inm = id_tipo_inm;
        cargar();
    }

    public TipoInmueble(int id_tipo_inm, String nombre_tipo_inm, boolean activo) {
        this.id_tipo_inm = id_tipo_inm;
        this.nombre_tipo_inm = nombre_tipo_inm;
        this.activo = activo;
    }

    private void limpiar() {
        this.id_tipo_inm = 0;
        this.nombre_tipo_inm = "";
        this.activo = false;
        this._existe = false;
    }

    public int getId_tipo_inm() {
        return id_tipo_inm;
    }

    public void setId_tipo_inm(int id_tipo_inm) {
        this.id_tipo_inm = id_tipo_inm;
    }

    public String getNombre_tipo_inm() {
        return nombre_tipo_inm;
    }

    public void setNombre_tipo_inm(String nombre_tipo_inm) {
        this.nombre_tipo_inm = nombre_tipo_inm;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "TipoInmueble{" + "id_tipo_inm=" + id_tipo_inm + ", nombre_tipo_inm=" + nombre_tipo_inm + ", activo=" + activo + '}';
    }

    private ErrorSistema grabar() {
        ErrorSistema err;
        StringBuilder sql;

        if (!this._existe) {
            this.id_tipo_inm = UtilDB.getSiguienteNumero("Tipos_inmuebles", "id_tipo_inm");
            sql = new StringBuilder("INSERT INTO Tipos_inmuebles VALUES(");
            sql.append(this.id_tipo_inm).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.nombre_tipo_inm)).append(",");
            sql.append(this.activo ? "1" : "0");
            sql.append(")");
            err = UtilDB.ejecutaSQL(sql.toString());
            if (err.getNumeroError() == 0) {
                this._existe = true;
            }
        } else {
            sql = new StringBuilder("UPDATE Tipos_inmuebles SET ");
            sql.append("nombre_tipo_inm =").append(Utilerias.CadenaEncomillada(this.nombre_tipo_inm)).append(",");
            sql.append("activo = ").append(this.activo ? "1" : "0");
            sql.append(" WHERE id_tipo_inm = ").append(this.id_tipo_inm);
            err = UtilDB.ejecutaSQL(sql.toString());
        }
        return err;
    }

    private void cargar() {
        String sql = "SELECT * FROM ﻿Tipos_inmuebles WHERE id_tipo_inm = " + this.id_tipo_inm;
        Resultados rst = UtilDB.ejecutaConsulta(sql);
        if (rst.next()) {
            cargar(rst);
        }
        rst.close();
    }

    private void cargar(Resultados rst) {
        this.id_tipo_inm = rst.getInt("id_tipo_inm");
        this.nombre_tipo_inm = rst.getString("nombre_tipo_inm");
        this.activo = rst.getBoolean("activo");
        this._existe = true;
    }

}
