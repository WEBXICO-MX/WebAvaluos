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

public class RegimenPropiedad implements Serializable {

    private int id_regimen;
    private String nombre_regimen;
    private boolean activo;
    private boolean _existe;

    public RegimenPropiedad() {
        limpiar();
    }

    public RegimenPropiedad(int id_regimen) {
        limpiar();
        this.id_regimen = id_regimen;
        cargar();
    }

    public RegimenPropiedad(int id_regimen, String nombre_regimen, boolean activo) {
        this.id_regimen = id_regimen;
        this.nombre_regimen = nombre_regimen;
        this.activo = activo;
    }

    private void limpiar() {
        this.id_regimen = 0;
        this.nombre_regimen = "";
        this.activo = false;
        this._existe = false;
    }

    public int getId_regimen() {
        return id_regimen;
    }

    public void setId_regimen(int id_regimen) {
        this.id_regimen = id_regimen;
    }

    public String getNombre_regimen() {
        return nombre_regimen;
    }

    public void setNombre_regimen(String nombre_regimen) {
        this.nombre_regimen = nombre_regimen;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "RegimenPropiedad{" + "id_regimen=" + id_regimen + ", nombre_regimen=" + nombre_regimen + ", activo=" + activo + '}';
    }

    public ErrorSistema grabar() {
        ErrorSistema err;
        StringBuilder sql;

        if (!this._existe) {
            this.id_regimen = UtilDB.getSiguienteNumero("Regimenes_propiedad", "id_regimen");
            sql = new StringBuilder("INSERT INTO Regimenes_propiedad VALUES(");
            sql.append(this.id_regimen).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.nombre_regimen)).append(",");
            sql.append(this.activo ? "1" : "0");
            sql.append(")");
            err = UtilDB.ejecutaSQL(sql.toString());
            if (err.getNumeroError() == 0) {
                this._existe = true;
            }

        } else {
            sql = new StringBuilder("UPDATE Regimenes_propiedad SET ");
            sql.append("nombre_regimen =").append(Utilerias.CadenaEncomillada(this.nombre_regimen)).append(",");
            sql.append("activo = ").append(this.activo ? "1" : "0");
            sql.append(" WHERE id_regimen = ").append(this.id_regimen);
            err = UtilDB.ejecutaSQL(sql.toString());
        }
        return err;

    }

    private void cargar() {
        String sql = "SELECT * FROM ﻿Regimenes_propiedad WHERE id_regimen = " + this.id_regimen;
        Resultados rst = UtilDB.ejecutaConsulta(sql);
        if (rst.next()) {
            cargar(rst);
        }
        rst.close();
    }

    private void cargar(Resultados rst) {
        this.id_regimen = rst.getInt("id_regimen");
        this.nombre_regimen = rst.getString("nombre_regimen");
        this.activo = rst.getBoolean("activo");
        this._existe = false;
    }

}
