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

public class EquipamientoUrbano implements Serializable {

    private int id_equipamiento;
    private String nombre_equipamiento;
    private boolean activo;
    private boolean _existe;

    public EquipamientoUrbano() {
        limpiar();
    }

    public EquipamientoUrbano(int id_equipamiento) {
        limpiar();
        this.id_equipamiento = id_equipamiento;
        cargar();
    }

    public EquipamientoUrbano(int id_equipamiento, String nombre_equipamiento, boolean activo) {
        this.id_equipamiento = id_equipamiento;
        this.nombre_equipamiento = nombre_equipamiento;
        this.activo = activo;
    }

    private void limpiar() {
        this.id_equipamiento = 0;
        this.nombre_equipamiento = "";
        this.activo = false;
        this._existe = false;
    }

    public int getId_equipamiento() {
        return id_equipamiento;
    }

    public void setId_equipamiento(int id_equipamiento) {
        this.id_equipamiento = id_equipamiento;
    }

    public String getNombre_equipamiento() {
        return nombre_equipamiento;
    }

    public void setNombre_equipamiento(String nombre_equipamiento) {
        this.nombre_equipamiento = nombre_equipamiento;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "EquipamientoUrbano{" + "id_equipamiento=" + id_equipamiento + ", nombre_equipamiento=" + nombre_equipamiento + ", activo=" + activo + '}';
    }

    public ErrorSistema grabar() {
        ErrorSistema err;
        StringBuilder sql;

        if (!this._existe) {
            this.id_equipamiento = UtilDB.getSiguienteNumero("Equipamiento_urbano", "id_equipamiento");
            sql = new StringBuilder("INSERT INTO Equipamiento_urbano VALUES(");
            sql.append(this.id_equipamiento).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.nombre_equipamiento)).append(",");
            sql.append(this.activo ? "1" : "0");
            sql.append(")");
            err = UtilDB.ejecutaSQL(sql.toString());
            if (err.getNumeroError() == 0) {
                this._existe = true;
            }

        } else {
            sql = new StringBuilder("UPDATE Equipamiento_urbano SET ");
            sql.append("nombre_equipamiento = ").append(Utilerias.CadenaEncomillada(this.nombre_equipamiento)).append(",");
            sql.append("activo = ").append(this.activo ? "1" : "0");
            sql.append(" WHERE id_equipamiento=").append(this.id_equipamiento);
            err = UtilDB.ejecutaSQL(sql.toString());

        }

        return err;

    }

    private void cargar() {
        String sql = "SELECT * FROM ﻿Equipamiento_urbano WHERE id_equipamiento=" + this.id_equipamiento;
        Resultados rst = UtilDB.ejecutaConsulta(sql);
        if (rst.next()) {
            cargar(rst);
        }
        rst.close();
    }

    private void cargar(Resultados rst) {
        this.id_equipamiento = rst.getInt("id_equipamiento");
        this.nombre_equipamiento = rst.getString("nombre_equipamiento");
        this.activo = rst.getBoolean("activo");
        this._existe = false;
    }

}
