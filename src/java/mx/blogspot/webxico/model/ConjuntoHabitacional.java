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

public class ConjuntoHabitacional implements Serializable {

    private int id_conjunto;
    private String nombre_conjunto;
    private Calendar fecha_registro;
    private boolean activo;
    private boolean _existe;

    public ConjuntoHabitacional() {
        limpiar();
    }

    public ConjuntoHabitacional(int id_conjunto) {
        limpiar();
        this.id_conjunto = id_conjunto;
        cargar();
    }

    public ConjuntoHabitacional(int id_conjunto, String nombre_conjunto, Calendar fecha_registro, boolean activo) {
        this.id_conjunto = id_conjunto;
        this.nombre_conjunto = nombre_conjunto;
        this.fecha_registro = fecha_registro;
        this.activo = activo;
    }

    private void limpiar() {
        this.id_conjunto = 0;
        this.nombre_conjunto = "";
        this.fecha_registro = null;
        this.activo = false;
        this._existe = false;
    }

    public int getId_conjunto() {
        return id_conjunto;
    }

    public void setId_conjunto(int id_conjunto) {
        this.id_conjunto = id_conjunto;
    }

    public String getNombre_conjunto() {
        return nombre_conjunto;
    }

    public void setNombre_conjunto(String nombre_conjunto) {
        this.nombre_conjunto = nombre_conjunto;
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
        return "ConjuntoHabitacional{" + "id_conjunto=" + id_conjunto + ", nombre_conjunto=" + nombre_conjunto + ", fecha_registro=" + fecha_registro + ", activo=" + activo + '}';
    }

    public ErrorSistema grabar() {
        ErrorSistema err;
        StringBuilder sql;
        if (!_existe) {
            this.id_conjunto = UtilDB.getSiguienteNumero("Conjuntos_habitacionales", "id_conjunto");
            sql = new StringBuilder("INSERT INTO Conjuntos_habitacionales VALUES(");
            sql.append(this.id_conjunto).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.nombre_conjunto)).append(",");
            sql.append("GETDATE()").append(",");
            sql.append(this.activo ? "1" : "0");
            sql.append(")");
            err = UtilDB.ejecutaSQL(sql.toString());
            if (err.getNumeroError() == 0) {
                _existe = true;
            }

        } else {
            sql = new StringBuilder("UPDATE Conjuntos_habitacionales SET ");
            sql.append("nombre_conjunto =").append(Utilerias.CadenaEncomillada(this.nombre_conjunto)).append(",");
            sql.append("activo=").append(this.activo ? "1" : "0");
            sql.append(" WHERE id_conjunto =").append(this.id_conjunto);
            err = UtilDB.ejecutaSQL(sql.toString());
        }
        return err;
    }

    private void cargar() {
        String sql = "SELECT * FROM ﻿Conjuntos_habitacionales WHERE id_conjunto = " + this.id_conjunto;
        Resultados rst = UtilDB.ejecutaConsulta(sql);
        if (rst.next()) {
            cargar(rst);
        }
        rst.close();
    }

    private void cargar(Resultados rst) {
        this.id_conjunto = rst.getInt("id_conjunto");
        this.nombre_conjunto = rst.getString("nombre_conjunto");
        this.fecha_registro = rst.getCalendar("fecha_registro");
        this.activo = rst.getBoolean("activo");
        this._existe = true;
    }

}
