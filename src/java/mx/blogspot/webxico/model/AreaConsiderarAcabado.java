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

public class AreaConsiderarAcabado implements Serializable {

    private int id_areas_considerar;
    private String nombre_consideracion;
    private boolean activo;
    private boolean _existe;

    public AreaConsiderarAcabado() {
        limpiar();
    }

    public AreaConsiderarAcabado(int id_areas_considerar) {
        limpiar();
        this.id_areas_considerar = id_areas_considerar;
        cargar();
    }

    public AreaConsiderarAcabado(int id_areas_considerar, String nombre_consideracion, boolean activo) {
        this.id_areas_considerar = id_areas_considerar;
        this.nombre_consideracion = nombre_consideracion;
        this.activo = activo;
    }

    private void limpiar() {
        this.id_areas_considerar = 0;
        this.nombre_consideracion = "";
        this.activo = false;
        this._existe = false;
    }

    public int getId_areas_considerar() {
        return id_areas_considerar;
    }

    public void setId_areas_considerar(int id_areas_considerar) {
        this.id_areas_considerar = id_areas_considerar;
    }

    public String getNombre_consideracion() {
        return nombre_consideracion;
    }

    public void setNombre_consideracion(String nombre_consideracion) {
        this.nombre_consideracion = nombre_consideracion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "AreaConsiderarAcabado{" + "id_areas_considerar=" + id_areas_considerar + ", nombre_consideracion=" + nombre_consideracion + ", activo=" + activo + '}';
    }

    public ErrorSistema grabar() {
        ErrorSistema err;
        StringBuilder sql;

        if (!this._existe) {
            this.id_areas_considerar = UtilDB.getSiguienteNumero("Areas_considerar_acabados", "id_areas_considerar");
            sql = new StringBuilder("INSERT INTO Areas_considerar_acabados VALUES(");
            sql.append(this.id_areas_considerar).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.nombre_consideracion)).append(",");
            sql.append(this.activo ? "1" : "0");
            sql.append(")");
            err = UtilDB.ejecutaSQL(sql.toString());
            if (err.getNumeroError() == 0) {
                this._existe = true;
            }
        } else {
            sql = new StringBuilder("UPDATE Areas_considerar_acabados SET ");
            sql.append("nombre_consideracion= ").append(Utilerias.CadenaEncomillada(this.nombre_consideracion)).append(",");
            sql.append("activo =").append(this.activo ? "1" : "0");
            sql.append(" WHERE id_areas_considerar= ").append(this.id_areas_considerar);
            err = UtilDB.ejecutaSQL(sql.toString());
        }

        return err;

    }

    private void cargar() {
        String sql = "SELECT * FROM ﻿Areas_considerar_acabados WHERE id_areas_considerar =" + this.id_areas_considerar;
        Resultados rst = UtilDB.ejecutaConsulta(sql);
        if (rst.next()) {
            cargar(rst);
        }
        rst.close();
    }

    private void cargar(Resultados rst) {
        this.id_areas_considerar = rst.getInt("id_areas_considerar");
        this.nombre_consideracion = rst.getString("nombre_consideracion");
        this.activo = rst.getBoolean("activo");
        this._existe = true;
    }

}
