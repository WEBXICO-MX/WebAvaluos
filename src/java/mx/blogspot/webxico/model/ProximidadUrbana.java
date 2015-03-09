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

public class ProximidadUrbana implements Serializable {

    private int id_proximidad;
    private String nombre_proximidad;
    private boolean activo;
    private boolean _existe;

    public ProximidadUrbana() {
        limpiar();
    }

    public ProximidadUrbana(int id_proximidad) {
        limpiar();
        this.id_proximidad = id_proximidad;
        cargar();
    }

    public ProximidadUrbana(int id_proximidad, String nombre_proximidad, boolean activo) {
        this.id_proximidad = id_proximidad;
        this.nombre_proximidad = nombre_proximidad;
        this.activo = activo;
    }

    private void limpiar() {
        this.id_proximidad = 0;
        this.nombre_proximidad = "";
        this.activo = false;
        this._existe = false;
    }

    public int getId_proximidad() {
        return id_proximidad;
    }

    public void setId_proximidad(int id_proximidad) {
        this.id_proximidad = id_proximidad;
    }

    public String getNombre_proximidad() {
        return nombre_proximidad;
    }

    public void setNombre_proximidad(String nombre_proximidad) {
        this.nombre_proximidad = nombre_proximidad;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "ProximidadUrbana{" + "id_proximidad=" + id_proximidad + ", nombre_proximidad=" + nombre_proximidad + ", activo=" + activo + '}';
    }

    public ErrorSistema grabar() {
        ErrorSistema err;
        StringBuilder sql;

        if (!this._existe) {
            this.id_proximidad = UtilDB.getSiguienteNumero("Proximidades_urbanas", "id_proximidad");
            sql = new StringBuilder("INSERT INTO Proximidades_urbanas VALUES(");
            sql.append(this.id_proximidad).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.nombre_proximidad)).append(",");
            sql.append(this.activo ? "1" : "0");
            sql.append(")");
            err = UtilDB.ejecutaSQL(sql.toString());

            if (err.getNumeroError() == 0) {
                this._existe = true;
            }

        } else {
            sql = new StringBuilder("UPDATE Proximidades_urbanas SET ");
            sql.append("nombre_proximidad =").append(Utilerias.CadenaEncomillada(this.nombre_proximidad)).append(",");
            sql.append("activo = ").append(this.activo ? "1" : "0");
            sql.append(" WHERE id_proximidad=").append(this.id_proximidad);
            err = UtilDB.ejecutaSQL(sql.toString());
        }
        return err;
    }

    private void cargar() {
        String sql = "SELECT * FROM ﻿Proximidades_urbanas WHERE id_proximidad=" + this.id_proximidad;
        Resultados rst = UtilDB.ejecutaConsulta(sql);
        if (rst.next()) {
            cargar(rst);
        }
        rst.close();
    }

    private void cargar(Resultados rst) {
        this.id_proximidad = rst.getInt("id_proximidad");
        this.nombre_proximidad = rst.getString("nombre_proximidad");
        this.activo = rst.getBoolean("activo");
        this._existe = true;
    }

}
