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

public class ClasificacionZona implements Serializable {

    private int id_clasificacion;
    private String nombre_clasificacion;
    private boolean activo;
    private boolean _existe;

    public ClasificacionZona() {
        limpiar();
    }

    public ClasificacionZona(int id_clasificacion) {
        limpiar();
        this.id_clasificacion = id_clasificacion;
        cargar();
    }

    public ClasificacionZona(int id_clasificacion, String nombre_clasificacion, boolean activo) {
        this.id_clasificacion = id_clasificacion;
        this.nombre_clasificacion = nombre_clasificacion;
        this.activo = activo;
    }

    private void limpiar() {
        this.id_clasificacion = 0;
        this.nombre_clasificacion = "";
        this.activo = false;
        this._existe = false;
    }

    public int getId_clasificacion() {
        return id_clasificacion;
    }

    public void setId_clasificacion(int id_clasificacion) {
        this.id_clasificacion = id_clasificacion;
    }

    public String getNombre_clasificacion() {
        return nombre_clasificacion;
    }

    public void setNombre_clasificacion(String nombre_clasificacion) {
        this.nombre_clasificacion = nombre_clasificacion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "ClasificacionZona{" + "id_clasificacion=" + id_clasificacion + ", nombre_clasificacion=" + nombre_clasificacion + ", activo=" + activo + '}';
    }

    public ErrorSistema grabar() {
        ErrorSistema err;
        StringBuilder sql;

        if (!this._existe) {
            this.id_clasificacion = UtilDB.getSiguienteNumero("Clasificaciones_zona", "id_clasificacion");
            sql = new StringBuilder("INSERT INTO Clasificaciones_zona VALUES(");
            sql.append(this.id_clasificacion).append(",");
            sql.append(Utilerias.CadenaEncomillada(this.nombre_clasificacion)).append(",");
            sql.append(this.activo ? "1" : "0");
            sql.append(")");
            err = UtilDB.ejecutaSQL(sql.toString());
            if (err.getNumeroError() == 0) {
                this._existe = true;
            }

        } else {
            sql = new StringBuilder("UPDATE Clasificaciones_zona SET ");
            sql.append("nombre_clasificacion = ").append(Utilerias.CadenaEncomillada(this.nombre_clasificacion)).append(",");
            sql.append("activo = ").append(this.activo ? "1" : "0");
            sql.append(" WHERE id_clasificacion = ").append(this.id_clasificacion);
            err = UtilDB.ejecutaSQL(sql.toString());
        }

        return err;

    }

    private void cargar() {
        String sql = "SELECT * FROM ﻿Clasificaciones_zona WHERE id_clasificacion=" + this.id_clasificacion;
        Resultados rst = UtilDB.ejecutaConsulta(sql);
        if (rst.next()) {
            cargar(rst);
        }
        rst.close();
    }

    private void cargar(Resultados rst) {
        this.id_clasificacion = rst.getInt("id_clasificacion");
        this.nombre_clasificacion = rst.getString("nombre_clasificacion");
        this.activo = rst.getBoolean("activo");
        this._existe = true;
    }

}
