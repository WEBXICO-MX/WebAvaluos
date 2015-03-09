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

public class UsoSuelo implements Serializable {

    private int id_uso_suelo;
    private String nombre_uso;
    private boolean activo;
    private boolean _existe;

    public UsoSuelo() {
        this.limpiar();
    }

    public UsoSuelo(int id_uso_suelo) {
        this.limpiar();
        this.id_uso_suelo = id_uso_suelo;
        cargar();
    }

    public UsoSuelo(int id_uso_suelo, String nombre_uso, boolean activo) {
        this.id_uso_suelo = id_uso_suelo;
        this.nombre_uso = nombre_uso;
        this.activo = activo;
    }

    private void limpiar() {
        this.id_uso_suelo = 0;
        this.nombre_uso = "";
        this.activo = false;
        this._existe = false;
    }

    public int getId_uso_suelo() {
        return id_uso_suelo;
    }

    public void setId_uso_suelo(int id_uso_suelo) {
        this.id_uso_suelo = id_uso_suelo;
    }

    public String getNombre_uso() {
        return nombre_uso;
    }

    public void setNombre_uso(String nombre_uso) {
        this.nombre_uso = nombre_uso;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "UsoSuelo{" + "id_uso_suelo=" + id_uso_suelo + ", nombre_uso=" + nombre_uso + ", activo=" + activo + '}';
    }

    public ErrorSistema grabar() {
        ErrorSistema err;
        StringBuilder sql;

        if (!this._existe) {
            this.id_uso_suelo = UtilDB.getSiguienteNumero("Usos_suelo", "id_uso_suelo");
            sql = new StringBuilder("INSERT INTO  Usos_suelo VALUES(");
            sql.append(this.id_uso_suelo).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.nombre_uso)).append(",");
            sql.append(this.activo ? "1" : "0");
            sql.append(")");
            err = UtilDB.ejecutaSQL(sql.toString());
            if (err.getNumeroError() == 0) {
                this._existe = true;
            }

        } else {
            sql = new StringBuilder("UPDATE Usos_suelo SET ");
            sql.append("nombre_uso=").append(Utilerias.CadenaEncomillada(this.nombre_uso)).append(",");
            sql.append("activo=").append(this.activo ? "1" : "0");
            sql.append(" WHERE id_uso_suelo=").append(this.id_uso_suelo);
            err = UtilDB.ejecutaSQL(sql.toString());
        }

        return err;
    }

    private void cargar() {
        String sql = "SELECT * FROM ﻿Usos_suelo where id_uso_suelo=" + this.id_uso_suelo;
        Resultados rst = UtilDB.ejecutaConsulta(sql);
        if (rst.next()) {
            cargar(rst);
        }
        rst.close();
    }

    private void cargar(Resultados rst) {
        this.id_uso_suelo = rst.getInt("id_uso_suelo");
        this.nombre_uso = rst.getString("nombre_uso");
        this.activo = rst.getBoolean("activo");
        this._existe = true;
    }

}
